package com.retrowalk.service;

import com.retrowalk.entities.User;
import com.retrowalk.models.UserRequest;

public interface UserService {

    User registerUser(UserRequest userRequest);
}
