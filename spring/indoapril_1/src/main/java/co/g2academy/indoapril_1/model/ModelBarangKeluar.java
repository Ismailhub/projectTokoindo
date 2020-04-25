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
@Table(name = "tb_barang_keluar")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelBarangKeluar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Barang_Keluar;
    private Integer Id_Barang;
    private String Nama_Barang;
    private Integer Qtt_Barang_Keluar;
    private String Tanggal_Keluar;

}
