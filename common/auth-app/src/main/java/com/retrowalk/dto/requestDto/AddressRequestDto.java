package com.retrowalk.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
