package skillbox.Security_JWT.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import skillbox.Security_JWT.model.*;

@RestController
@RequestMapping("/api/v1/auth/admin")
public class AdminController {

    @PostMapping("/revokeUserTokens/{email}")
    public ResponseEntity<String> revokeUserTokens(@PathVariable String email) {
        // Реализация метода для отзыва токенов пользователя
        return null;
    }

    @PostMapping("/revokeAllTokens")
    public ResponseEntity<String> revokeAllTokens() {
        // Реализация метода для отзыва всех токенов
        return null;
    }

    @GetMapping("/getActiveUsers")
    public ResponseEntity<String> getActiveUsers() {
        // Реализация метода для получения списка активных пользователей
        return null;
    }
}
