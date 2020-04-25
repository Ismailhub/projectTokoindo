package co.g2academy.indoapril_1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_barang_masuk")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelBarangMasuk implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Barang_Masuk;
    private String Nomor_Surat_Jalan;
    private String Nama_Barang;
    private String Nama_Supplier;
    private Integer Qtt_Barang_Masuk;
    private String Tanggal_Pemesanan;
    private String Tanggal_Masuk;


}
