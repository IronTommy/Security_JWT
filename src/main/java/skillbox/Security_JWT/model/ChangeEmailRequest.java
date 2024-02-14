package skillbox.Security_JWT.model;

public class ChangeEmailRequest {
    private String email;

    public ChangeEmailRequest() {
    }

    public ChangeEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
