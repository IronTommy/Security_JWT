package skillbox.Security_JWT.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import skillbox.Security_JWT.model.*;

@RestController
@RequestMapping("/api/v1/auth/password")
public class PasswordController {

    @PostMapping("/recovery/{recoveryTokenId}")
    public ResponseEntity<String> recoverPassword(@PathVariable String recoveryTokenId, @RequestBody PasswordRecoveryRequest request) {
        // Реализация метода для восстановления пароля
        return null;
    }

    @PostMapping("/recovery")
    public ResponseEntity<String> sendRecoveryEmail(@RequestBody RecoveryEmailRequest request) {
        // Реализация метода для отправки письма с ссылкой на восстановление пароля
        return null;
    }

    @PostMapping("/change-password-link")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        // Реализация метода для изменения пароля
        return null;
    }
}
