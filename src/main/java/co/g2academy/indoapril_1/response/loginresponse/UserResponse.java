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
    private String alamat_penempatan;
    private String telephon_user;
    private String status;

    public UserResponse(
            int id_User,
            String nama_User,
            String username,
            String password,
            String alamat_penempatan,
            String telephon_user,
            String status
    ) {
        this.id_User = id_User;
        this.nama_User = nama_User;
        this.username = username;
        this.password = password;
        this.alamat_penempatan = alamat_penempatan;
        this.telephon_user = telephon_user;
        this.status = status;
    }

}
