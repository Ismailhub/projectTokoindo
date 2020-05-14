package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
public class ResponseProductMasuk {

    private Integer idProductMasuk;
    private Integer qtyMasuk;
    private String tanggalMasuk;
    private Integer idProduct;

    public ResponseProductMasuk(
            Integer idProductMasuk,
            Integer qtyMasuk,
            String tanggalMasuk,
            Integer idProduct
    ) {
        this.idProductMasuk = idProductMasuk;
        this.qtyMasuk = qtyMasuk;
        this.tanggalMasuk = tanggalMasuk;
        this.idProduct = idProduct;
    }

}
