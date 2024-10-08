package com.retrowalk.controller;

import com.retrowalk.dto.LoginRequestDto;
import com.retrowalk.dto.LoginResponseDto;
import com.retrowalk.enums.SuccessMessage;
import com.retrowalk.models.Response;
import com.retrowalk.models.SuccessResponse;
import com.retrowalk.service.JwtService;
import com.retrowalk.utility.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    private MessageUtils messageUtils;

    @PostMapping("/login")
    public ResponseEntity<?> AuthenticateAndGetToken(@RequestBody LoginRequestDto loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
            LoginResponseDto loginResponse = LoginResponseDto.builder()
                    .token(jwtService.generateToken(loginRequestDTO.getUsername())).build();

        /* Return the ResponseEntity */
        return Response.build(SuccessResponse.class)
                .with(s -> s.setData(loginResponse))
                .with(s -> s.setStatusCode(SuccessMessage.LOGIN_SUCCESS.getCode()))
                .with(s -> s.setMessage(messageUtils.getMessage(SuccessMessage.LOGIN_SUCCESS.getMessage(), null)))
                .get().getResponseEntity();

    }
}
