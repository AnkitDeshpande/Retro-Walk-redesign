package com.retrowalk.service;

import com.retrowalk.entities.Token;

public interface TokenService {
    Token findByToken(String token);

    Token save(Token token);
}
