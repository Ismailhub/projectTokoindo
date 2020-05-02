package co.g2academy.indoapril_1.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_barang_masuk")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelInventoryReport implements Serializable {
    @Id
    private int Id_Barang_Masuk;
    private String Nomor_Surat_Jalan;
    private Integer Id_Barang;
    private Integer Qtt_Barang_Masuk;
    private Date Tanggal_Pemesanan ;
    private Date Tanggal_Masuk;
    private String Nama_Barang;
    private Integer Qty_Detail; //sebagai barang keluar
    private Integer Qty_Stock;
    private Integer Qty_Min_Stock;
    private Date Tgl_Order;
}
