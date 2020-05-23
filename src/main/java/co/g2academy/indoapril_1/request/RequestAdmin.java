package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAdmin {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer idAdmin;
    private String namaAdmin;
    private String email;
    private String password;
    private String telephon;
    private String status;
    private String token;


    public void setPassword( String password ) {

        this.password = password;

    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephon() {
        return telephon;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

}