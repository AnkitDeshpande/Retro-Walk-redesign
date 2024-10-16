package com.retrowalk.service.impl;

import com.retrowalk.entities.User;
import com.retrowalk.exception.RetrowalkException;
import com.retrowalk.models.request.ChangePasswordRequest;
import com.retrowalk.repository.UserRepository;
import com.retrowalk.service.AuthService;
import com.retrowalk.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    @Override
    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new RetrowalkException(404, "User not found: " + username);
        }
    }

    @Override
    public void verifyEmail(String verificationToken) {
        // Assume you have a method to validate the token and get the user
       /* User user = userRepository.findByVerificationToken(verificationToken);
        if (user != null) {
            user.setEmailVerified(true);
            userRepository.save(user);
        } else {
            throw new RetrowalkException(400, "Invalid verification token");
        }*/
    }

    @Override
    public void resetPassword(String email) {
        Optional<User> user = userRepository.findByEmail(email);
       /* if (user.isPresent()) {
            String token = generatePasswordResetToken();
            emailService.sendPasswordResetEmail(user.getEmail(), token);
        } else {
            throw new RetrowalkException(404, "User not found with email: " + email);
        }*/
    }

    @Override
    @Transactional
    public void changePassword(String username, ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(username);
        if (user != null) {

            user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
            userRepository.save(user);

        } else {
            throw new RetrowalkException(404, "User not found: " + username);
        }
    }

    @Override
    public void logout() {
        // Implement your logout logic here, such as invalidating tokens or session
    }
}
