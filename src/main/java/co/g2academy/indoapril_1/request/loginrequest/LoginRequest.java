package co.g2academy.indoapril_1.request.loginrequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
