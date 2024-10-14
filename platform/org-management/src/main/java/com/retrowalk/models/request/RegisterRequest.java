package com.retrowalk.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private UserRequest userDto;
    private AccountRequest accountDto;
    private BusinessRequest businessDto;
    private Boolean isBusiness;
}
