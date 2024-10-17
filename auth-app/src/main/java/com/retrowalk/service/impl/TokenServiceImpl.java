package com.retrowalk.service.impl;

import com.retrowalk.entities.Token;
import com.retrowalk.repository.TokenRepository;
import com.retrowalk.service.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    @Transactional
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    @Transactional
    public Token save(Token token) {
        return tokenRepository.save(token);
    }
}
