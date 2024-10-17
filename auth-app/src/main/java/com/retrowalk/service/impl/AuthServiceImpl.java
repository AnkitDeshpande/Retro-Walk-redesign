package com.retrowalk.service.impl;

import com.retrowalk.entities.Token;
import com.retrowalk.entities.User;
import com.retrowalk.enums.ErrorMessage;
import com.retrowalk.enums.TokenType;
import com.retrowalk.exception.RetrowalkException;
import com.retrowalk.models.request.ChangePasswordRequest;
import com.retrowalk.models.request.LoginRequest;
import com.retrowalk.models.response.LoginResponse;
import com.retrowalk.service.AuthService;
import com.retrowalk.service.EmailService;
import com.retrowalk.service.TokenService;
import com.retrowalk.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final TokenService tokenService;

    @Override
    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        String generatedToken = jwtService.generateToken(loginRequest.getUsername());

        // Save the token for the authenticated user
        Token token = new Token();
        token.setToken(generatedToken);
        token.setTokenType(TokenType.LOGIN.name());
        token.setUser(userService.findByUsername(loginRequest.getUsername()));
        token.setIsDeleted(Boolean.FALSE);
        tokenService.save(token);

        return LoginResponse.builder().username(authentication.getName()).token(jwtService.generateToken(loginRequest.getUsername())).build();
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            user.setActive(Boolean.FALSE);
            user.setIsDeleted(Boolean.FALSE);
            userService.save(user);
        } else {
            throw new RetrowalkException(404, ErrorMessage.USER_NOT_FOUND.getMessage());
        }
    }

    @Override
    @Transactional
    public void changePassword(String username, ChangePasswordRequest changePasswordRequest) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new RetrowalkException(ErrorMessage.USER_NOT_FOUND.getCode(),
                    ErrorMessage.USER_NOT_FOUND.getMessage());
        }


        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new RetrowalkException(ErrorMessage.INCORRECT_OLD_PASSWORD.getCode(),
                    ErrorMessage.INCORRECT_OLD_PASSWORD.getMessage());
        }

        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
            throw new RetrowalkException(ErrorMessage.PASSWORDS_DO_NOT_MATCH.getCode(),
                    ErrorMessage.PASSWORDS_DO_NOT_MATCH.getMessage());
        }

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        userService.save(user);
    }

    @Override
    @Transactional
    public void logout(String token) {
        if (token == null || token.isEmpty()) {
            throw new RetrowalkException(ErrorMessage.TOKEN_REQUIRED.getCode(), ErrorMessage.TOKEN_REQUIRED.getMessage());
        }

        Token existingToken = tokenService.findByToken(token);
        if (existingToken != null) {
            existingToken.setIsDeleted(Boolean.TRUE);
            tokenService.save(existingToken);
        } else {
            throw new RetrowalkException(ErrorMessage.TOKEN_NOT_FOUND.getCode(), ErrorMessage.TOKEN_NOT_FOUND.getMessage());
        }
    }
}
