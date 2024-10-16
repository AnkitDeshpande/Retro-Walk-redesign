package com.retrowalk.controller;

import com.retrowalk.dto.requestDto.LoginRequestDto;
import com.retrowalk.dto.requestDto.SignUpRequestDto;
import com.retrowalk.dto.responseDto.LoginResponseDto;
import com.retrowalk.dto.responseDto.SignUpResponseDto;
import com.retrowalk.entities.User;
import com.retrowalk.enums.Headers;
import com.retrowalk.enums.SuccessMessage;
import com.retrowalk.models.request.ChangePasswordRequest;
import com.retrowalk.models.request.SignUpRequest;
import com.retrowalk.repository.UserRepository;
import com.retrowalk.service.UserService;
import com.retrowalk.service.impl.JwtService;
import com.retrowalk.utility.Mapper;
import com.retrowalk.utility.MessageUtils;
import com.retrowalk.utility.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final MessageUtils messageUtils;

    private final UserService userService;

    private final Mapper mapper;

    @PostMapping("/login")
    public SuccessResponse<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        LoginResponseDto loginResponse = LoginResponseDto.builder().username(authentication.getName()).token(jwtService.generateToken(loginRequestDTO.getUsername())).build();

        /* Return the ResponseEntity */
        return SuccessResponse.<LoginResponseDto>builder()
                .data(loginResponse)
                .statusCode(SuccessMessage.LOGIN_SUCCESS.getCode())
                .message(SuccessMessage.LOGIN_SUCCESS.getMessage())
                .build();
    }

    @PostMapping("/signup")
    public SuccessResponse<SignUpResponseDto> register(@RequestBody SignUpRequestDto signUpRequestDto) {
        User user = userService.saveUser(mapper.convert(signUpRequestDto, SignUpRequest.class));
        SignUpResponseDto dtoTOSend = mapper.convert(user, SignUpResponseDto.class);
        /* Return the ResponseEntity */
        return SuccessResponse.<SignUpResponseDto>builder()
                .data(dtoTOSend)
                .statusCode(SuccessMessage.SIGN_UP_SUCCESS.getCode())
                .message(SuccessMessage.SIGN_UP_SUCCESS.getMessage())
                .build();
    }

    @PostMapping("/logout")
    public SuccessResponse<String> logout() {

        return SuccessResponse.<String>builder()
                .data(null)
                .statusCode(SuccessMessage.LOGOUT_SUCCESS.getCode())
                .message(SuccessMessage.LOGOUT_SUCCESS.getMessage())
                .build();
    }

    @PostMapping("/reset-password")
    public SuccessResponse<String> resetPassword(@RequestBody ChangePasswordRequest passwordResetDto) {


        return SuccessResponse.<String>builder()
                .data(null)
                .statusCode(SuccessMessage.RESET_PASSWORD.getCode())
                .message(SuccessMessage.RESET_PASSWORD.getMessage())
                .build();
    }
}
