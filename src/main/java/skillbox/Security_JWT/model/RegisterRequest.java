package skillbox.Security_JWT.model;

public class RegisterRequest {
    private String id;
    private boolean isDeleted;
    private String firstName;
    private String lastName;
    private String email;
    private String password1;
    private String password2;
    private String captchaCode;
    private String captchaSecret;
}
