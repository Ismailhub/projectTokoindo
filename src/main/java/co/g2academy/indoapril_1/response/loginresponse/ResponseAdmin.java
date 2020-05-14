package co.g2academy.indoapril_1.response.loginresponse;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ResponseAdmin {

    private Integer idAdmin;
    private String namaAdmin;
    private String email;
    private String password;
    private String telephon;
    private String status;
    private String token;


    public ResponseAdmin(
            Integer idAdmin,
            String namaAdmin,
            String email,
            String password,
            String telephon,
            String status,
            String token
    ) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.email = email;
        this.password = password;
        this.telephon = telephon;
        this.status = status;
        this.token = token;
    }

}
