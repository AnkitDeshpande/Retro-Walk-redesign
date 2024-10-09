package com.retrowalk.controller;

import com.retrowalk.dto.LoginRequestDto;
import com.retrowalk.dto.LoginResponseDto;
import com.retrowalk.enums.SuccessMessage;
import com.retrowalk.repository.UserRepository;
import com.retrowalk.service.JwtService;
import com.retrowalk.utility.MessageUtils;
import com.retrowalk.utility.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final MessageUtils messageUtils;

    @PostMapping("/login")
    public SuccessResponse<LoginResponseDto> AuthenticateAndGetToken(@RequestBody LoginRequestDto loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        LoginResponseDto loginResponse = LoginResponseDto.builder().username(authentication.getName()).token(jwtService.generateToken(loginRequestDTO.getUsername())).build();

        /* Return the ResponseEntity */
        return SuccessResponse.<LoginResponseDto>builder()
                .data(loginResponse)
                .statusCode(SuccessMessage.LOGIN_SUCCESS.getCode())
                .message("Login successful")
                .build();
    }
}
