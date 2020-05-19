package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product_masuk")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelProductMasuk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProductMasuk;
    private Integer qtyMasuk;
    private Date tanggalMasuk;
    private Integer idProduct;

}
