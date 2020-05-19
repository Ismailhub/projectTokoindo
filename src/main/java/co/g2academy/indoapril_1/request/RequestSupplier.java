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
public class RequestSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSupplier;
    private String namaSupplier;
    private String alamatSupplier;
    private String telepon;

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public String getAlamatSupplier() {
        return alamatSupplier;
    }

    public String getTelepon() {
        return telepon;
    }

}
