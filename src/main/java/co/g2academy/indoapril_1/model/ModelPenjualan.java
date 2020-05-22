package co.g2academy.indoapril_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String statusTracking;
    private Date tanggalPenjualan;
    private Integer idCustomer;
    private Blob gambarBuktiTransfer;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "penjualan"
    )
    private List<ModelTracking> trackings = new ArrayList<>();

}
