package com.retrowalk.service;

import com.retrowalk.models.request.ChangePasswordRequest;
import com.retrowalk.models.request.LoginRequest;
import com.retrowalk.models.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    void deleteUser(String username);

    void changePassword(String username, ChangePasswordRequest changePasswordRequest);

    void logout(String token);
}

