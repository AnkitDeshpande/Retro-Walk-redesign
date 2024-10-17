package com.retrowalk.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    private Long id;
    private String username;
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
