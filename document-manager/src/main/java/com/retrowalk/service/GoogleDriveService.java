package com.retrowalk.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* class to demonstrate use of Drive files list API */
@Component
public class GoogleDriveService {

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "RetroWalk";

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_FILE);

    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static final Logger log = LoggerFactory.getLogger(GoogleDriveService.class);

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleDriveService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .setApprovalPrompt("force").build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
                .setCallbackPath("/callback")
                .setPort(8888).build();
        //returns an authorized Credential object.
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public Drive getInstance() throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
    }

    public String getFiles() throws IOException, GeneralSecurityException {

        Drive service = getInstance();

        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list().setPageSize(10).execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            log.info("No files found.");
            return "No files found.";
        } else {
            return files.toString();
        }
    }


    public String uploadFile(MultipartFile file) {
        try {
            String folderId = "1KK9XFor_Ep8dri-207JHO39ya1uyvFw4";
            if (Objects.nonNull(file)) {
                File fileMetadata = new File();
                fileMetadata.setParents(Collections.singletonList(folderId));
                fileMetadata.setName(file.getOriginalFilename());
                File uploadFile = getInstance().files()
                        .create(fileMetadata, new InputStreamContent(file.getContentType(), new ByteArrayInputStream(file.getBytes())))
                        .setFields("id").execute();
                System.out.println(uploadFile);
                return uploadFile.getId();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}