package com.retrowalk.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class EmailDetailDto {
    private String to;
    private String subject;
    private Map<String, Object> dynamicValue;
    private String templateName;
}