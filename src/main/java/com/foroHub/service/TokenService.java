package com.foroHub.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}") 
    private long expiration;

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(secret));
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return JWT.decode(token).getSubject();
    }
}
