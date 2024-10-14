package com.retrowalk.service.impl;

import com.retrowalk.entities.Address;
import com.retrowalk.entities.User;
import com.retrowalk.exception.RetrowalkException;
import com.retrowalk.models.request.SignUpRequest;
import com.retrowalk.repository.UserRepository;
import com.retrowalk.service.UserService;
import com.retrowalk.utility.Mapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link UserDetailsService} interface to load user-specific data.
 * This service fetches user details from the database.
 */

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    private final Mapper mapper = new Mapper();

    /**
     * Loads user details by username.
     *
     * @param username the username of the user
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    /**
     * Registers a new user.
     *
     * @param signUpRequest the sign-up request data transfer object
     * @return the registered User
     */
    @Override
    @Transactional // Ensure that user registration is transactional
    public User registerUser(SignUpRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RetrowalkException(500, "User already exists with the username: " + signUpRequest.getUsername());
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RetrowalkException(500, "Email already in use: " + signUpRequest.getEmail());
        }

        User userToSave = new User();
        userToSave.setUsername(signUpRequest.getUsername());
        userToSave.setEmail(signUpRequest.getEmail());
        userToSave.setFirstName(signUpRequest.getFirstName());
        userToSave.setLastName(signUpRequest.getLastName());
        userToSave.setPhoneNumber(signUpRequest.getPhoneNumber());
        userToSave.setDateOfBirth(signUpRequest.getDateOfBirth());
        userToSave.setProfilePictureUrl(signUpRequest.getProfilePictureUrl());

        if (signUpRequest.getAddress() != null) {
            userToSave.getAddresses().add(mapper.convert(signUpRequest.getAddress(), Address.class));
        }

        return userRepository.save(userToSave);
    }
}
