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
@Table(name = "tb_order_detail")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelOrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int No;
    private String Id_Order;
    private Integer Id_Barang;
    private Integer Qty_Detail;
    private String Tgl_Order;
    private String Nama_Barang;
    private String Alamat_Penempatan;

}