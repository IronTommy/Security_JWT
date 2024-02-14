package skillbox.Security_JWT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skillbox.Security_JWT.model.CaptchaResponse;

@RestController
@RequestMapping("/api/v1/auth/captcha")
public class CaptchaController {

    @GetMapping
    public ResponseEntity<CaptchaResponse> getCaptcha() {
        // Реализация метода для получения капчи
        return null;
    }
}
