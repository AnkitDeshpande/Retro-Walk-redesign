package com.retrowalk.service;

import com.retrowalk.entities.User;
import com.retrowalk.models.request.ChangePasswordRequest;

public interface AuthService {

    void deleteUser(String username);

    void verifyEmail(String verificationToken);

    void resetPassword(String email);

    void changePassword(String username, ChangePasswordRequest changePasswordRequest);

    void logout(String token);
}

