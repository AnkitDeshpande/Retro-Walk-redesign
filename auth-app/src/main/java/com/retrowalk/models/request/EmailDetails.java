package com.retrowalk.models.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class EmailDetails {
    private String recipient;
    private String subject;
    private String messageBody;
}