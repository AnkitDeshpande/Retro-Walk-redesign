package com.retrowalk.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.retrowalk.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class DocumentManagerController {

    @Autowired
    private GoogleDriveService service;


    @GetMapping("/get-all-images")
    public  String sample() throws IOException, GeneralSecurityException{
        return service.getFiles();
    }

    @PostMapping(value = "/upload-file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @CrossOrigin(origins = "http://localhost:5151")
    public  String upload(@RequestPart("file") MultipartFile file) throws IOException, GeneralSecurityException{
        return service.uploadFile(file);
    }
}
