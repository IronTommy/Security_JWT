package skillbox.Security_JWT.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import skillbox.Security_JWT.util.DefaultTokenCookieFactory;
import skillbox.Security_JWT.model.Token;

import java.time.Instant;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

public class TokenCookieSessionAuthenticationStrategy implements SessionAuthenticationStrategy {

    private Function<Authentication, Token> tokenCookieFactory = new DefaultTokenCookieFactory();

    private Function<Token, String> tokenStringSerializer = Objects::toString;

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request,
                                 HttpServletResponse response) throws SessionAuthenticationException {
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            var token = this.tokenCookieFactory.apply(authentication);
            var tokenString = this.tokenStringSerializer.apply(token);

            Duration duration = Duration.between(Instant.now(), token.expiresAt());
            long seconds = duration.getSeconds();

            var cookie = new Cookie("__Host-auth-token", tokenString);
            cookie.setPath("/");
            cookie.setDomain(null);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setMaxAge((int) seconds);

            response.addCookie(cookie);
        }
    }

    public void setTokenCookieFactory(Function<Authentication, Token> tokenCookieFactory) {
        this.tokenCookieFactory = tokenCookieFactory;
    }

    public void setTokenStringSerializer(Function<Token, String> tokenStringSerializer) {
        this.tokenStringSerializer = tokenStringSerializer;
    }
}