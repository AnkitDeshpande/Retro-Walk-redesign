package com.retrowalk.service;

import com.retrowalk.models.request.EmailDetails;

public interface EmailService {

    void sendActivationEmail(EmailDetails emailDetails);
}
