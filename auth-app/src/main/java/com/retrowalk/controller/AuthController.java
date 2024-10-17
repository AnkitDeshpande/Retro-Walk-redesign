package com.retrowalk.controller;

import com.retrowalk.dto.requestDto.ChangePasswordRequestDto;
import com.retrowalk.dto.requestDto.LoginRequestDto;
import com.retrowalk.dto.requestDto.PasswordRequestDto;
import com.retrowalk.dto.requestDto.SignUpRequestDto;
import com.retrowalk.dto.responseDto.LoginResponseDto;
import com.retrowalk.dto.responseDto.SignUpResponseDto;
import com.retrowalk.entities.User;
import com.retrowalk.enums.SuccessMessage;
import com.retrowalk.models.request.ChangePasswordRequest;
import com.retrowalk.models.request.LoginRequest;
import com.retrowalk.models.request.PasswordRequest;
import com.retrowalk.models.request.SignUpRequest;
import com.retrowalk.models.response.LoginResponse;
import com.retrowalk.service.AuthService;
import com.retrowalk.service.UserService;
import com.retrowalk.utility.Mapper;
import com.retrowalk.utility.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    private final Mapper mapper;

    @PostMapping("/login")
    public SuccessResponse<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDTO) {
        LoginResponse loginResponse = authService.login(mapper.convert(loginRequestDTO, LoginRequest.class));
        LoginResponseDto loginResponseDto = mapper.convert(loginResponse, LoginResponseDto.class);

        /* Return the ResponseEntity */
        return SuccessResponse.<LoginResponseDto>builder()
                .data(loginResponseDto)
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
    public SuccessResponse<String> resetPassword(@RequestBody ChangePasswordRequestDto passwordResetDto) {
        authService.changePassword(passwordResetDto.getUsername(), mapper.convert(passwordResetDto, ChangePasswordRequest.class));
        return SuccessResponse.<String>builder()
                .data(null)
                .statusCode(SuccessMessage.RESET_PASSWORD.getCode())
                .message(SuccessMessage.RESET_PASSWORD.getMessage())
                .build();
    }

    @PostMapping("/activate")
    public SuccessResponse<String> activateUser(@RequestParam("email") String email, @RequestParam("token") String token,
                                                @RequestParam("expiresAt") String expiresAt, @RequestBody PasswordRequestDto passwordRequestDto) {
        boolean isActivated = userService.activateUser(email, token, expiresAt, mapper.convert(passwordRequestDto, PasswordRequest.class));
        return SuccessResponse.<String>builder()
                .data(null)
                .statusCode(SuccessMessage.USER_ACTIVATED.getCode())
                .message(SuccessMessage.USER_ACTIVATED.getMessage())
                .build();
    }
}
