package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_penjualan_detail")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelPenjualanDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer no;
    private Integer qtyPenjualan;
    private Integer subTotal;
    private Integer idProduct;
    private String idPenjualan;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "idPenjualan", insertable = false, updatable = false )
    private ModelPenjualan penjualan;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "idProduct", insertable = false, updatable = false )
    private ModelProduct products;

}