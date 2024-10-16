package com.retrowalk.service;

import com.retrowalk.entities.User;
import com.retrowalk.models.request.SignUpRequest;

public interface UserService {

    User saveUser(SignUpRequest signUpRequest);
}
