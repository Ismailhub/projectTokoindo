package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductMasuk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProductMasuk;
    private Integer qtyMasuk;
    private Date tanggalMasuk;
    private Integer idProduct;

    public Integer getIdProduct() {

        return idProduct;

    }

    public Integer getQtyMasuk() {

        return qtyMasuk;

    }


}
