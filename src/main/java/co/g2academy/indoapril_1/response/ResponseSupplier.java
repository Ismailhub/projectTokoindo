package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
public class ResponseSupplier {

    private Integer idSupplier;
    private String namaSupplier;
    private String alamatSupplier;
    private String telepon;

    public ResponseSupplier(Integer idSupplier, String namaSupplier, String alamatSupplier, String telepon) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.alamatSupplier = alamatSupplier;
        this.telepon = telepon;
    }
}
