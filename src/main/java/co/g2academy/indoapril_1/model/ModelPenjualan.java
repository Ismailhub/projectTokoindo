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
@Table(name = "tb_penjualan")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelPenjualan implements Serializable {

    @Id
    private String idPenjualan;
    private Integer totalPenjualan;
    private Integer totalBayar;
    private String alamatTujuan;
    private String metodePembayaran;
    private String statusPembayaran;
    private Date tanggalPenjualan;
    private Integer idCustomer;

}

//    @ManyToOne
//    @JoinColumn(
//            name = "id_user",
//            insertable = false,
//            updatable = false
//    )
//    private UserModel user;