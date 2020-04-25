package co.g2academy.indoapril_1.response.loginresponse;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserResponse {
    private int id_User;
    private String nama_User;
    private String username;
    private String password;

    public UserResponse(int id_User, String nama_User, String username, String password) {
        this.id_User = id_User;
        this.nama_User = nama_User;
        this.username = username;
        this.password = password;
    }
}
