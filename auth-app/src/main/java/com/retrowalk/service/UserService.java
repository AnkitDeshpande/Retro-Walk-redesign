package com.retrowalk.service;

import com.retrowalk.entities.User;
import com.retrowalk.models.request.PasswordRequest;
import com.retrowalk.models.request.SignUpRequest;

public interface UserService {

    User saveUser(SignUpRequest signUpRequest);

    boolean activateUser(String email, String token, String expiresAt, PasswordRequest passwordRequest);

    User findByUsername(String username);

    User save(User user);
}
