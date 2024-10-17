package com.retrowalk.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDetails {
    private String recipient;
    private String subject;
    private String messageBody;
}