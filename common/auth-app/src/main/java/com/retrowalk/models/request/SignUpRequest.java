package com.retrowalk.models.request;

import com.retrowalk.models.AddressRequest;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class SignUpRequest {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String profilePictureUrl;
    private AddressRequest address;
}
