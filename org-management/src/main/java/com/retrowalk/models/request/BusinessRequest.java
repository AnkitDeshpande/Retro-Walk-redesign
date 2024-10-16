package com.retrowalk.models.request;

import com.retrowalk.enums.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRequest {
    private String businessName;
    private BusinessType businessType;
}
