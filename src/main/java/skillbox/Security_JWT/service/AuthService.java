package skillbox.Security_JWT.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import skillbox.Security_JWT.model.AuthResponse;
import skillbox.Security_JWT.model.LoginRequest;
import skillbox.Security_JWT.model.RefreshRequest;
import skillbox.Security_JWT.model.Token;
import skillbox.Security_JWT.security.TokenCookieJweStringSerializer;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService {

    private final JdbcTemplate jdbcTemplate;
    private final TokenCookieJweStringSerializer tokenCookieJweStringSerializer;

    public AuthService(JdbcTemplate jdbcTemplate, TokenCookieJweStringSerializer tokenCookieJweStringSerializer) {
        this.jdbcTemplate = jdbcTemplate;
        this.tokenCookieJweStringSerializer = tokenCookieJweStringSerializer;
    }

    public AuthResponse authenticate(LoginRequest request) {
        Token accessToken = generateAccessToken(request.getUsername());
        Token refreshToken = generateRefreshToken(request.getUsername());

        return new AuthResponse(accessToken, refreshToken);
    }

    private Token generateAccessToken(String username) {
        Instant now = Instant.now();
        Instant expiresAt = now.plus(Duration.ofMinutes(5));
        return new Token(UUID.randomUUID(), username, Collections.emptyList(), now, expiresAt);
    }

    private Token generateRefreshToken(String username) {
        Instant now = Instant.now();
        Instant expiresAt = now.plus(Duration.ofDays(1));
        return new Token(UUID.randomUUID(), username, Collections.emptyList(), now, expiresAt);
    }

    public AuthResponse refreshToken(RefreshRequest request) {

        return null;
    }


    private boolean isValidRefreshToken(Token refreshToken) {
        return refreshToken.expiresAt().isAfter(Instant.now());
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
