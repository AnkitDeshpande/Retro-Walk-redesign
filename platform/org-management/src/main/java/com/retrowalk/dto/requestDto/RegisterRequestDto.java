package com.retrowalk.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private UserDto userDto;
    private AccountDto accountDto;
    private BusinessDto businessDto;
    private Boolean isBusiness;
}
