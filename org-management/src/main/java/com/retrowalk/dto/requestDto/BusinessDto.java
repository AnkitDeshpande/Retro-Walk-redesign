package com.retrowalk.dto.requestDto;

import com.retrowalk.enums.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDto {
    private String businessName;
    private BusinessType businessType;
}
