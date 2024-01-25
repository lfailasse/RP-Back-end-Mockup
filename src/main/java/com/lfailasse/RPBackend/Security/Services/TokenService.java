package com.lfailasse.RPBackend.Security.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lfailasse.RPBackend.Security.Models.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("pandora-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(expirationTime())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException jwtException) {
            throw new RuntimeException("Erro ao gerar o token", jwtException);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("pandora-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException jwtException) {
            return "";
        }
    }

    public Instant expirationTime() {
        return LocalDateTime.now().plusHours(9).toInstant(ZoneOffset.of("-03:00"));
    }

}
