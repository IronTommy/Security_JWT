package skillbox.Security_JWT.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import skillbox.Security_JWT.model.*;

@RestController
@RequestMapping("/api/v1/auth/email")
public class EmailController {

    @PostMapping("/change-email-link")
    public ResponseEntity<String> changeEmail(@RequestBody ChangeEmailRequest request) {
        // Реализация метода для изменения почты
        return null;
    }
}
