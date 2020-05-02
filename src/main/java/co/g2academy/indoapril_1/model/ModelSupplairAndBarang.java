//package co.g2academy.indoapril_1.model;
//
//public class ModelSupplairAndBarang {
//
//}
package co.g2academy.indoapril_1.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_supplier")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ModelSupplairAndBarang implements Serializable {

    // di bawah @id harus uniq jika join 2 table cari id yg uniq agar tidak ada data yg sama tampil berulang2
    @Id
    private Integer Id_Barang;
    private Integer Id_Supplier;
    private String Nama_Supplier;
    private String Alamat_Supplier;
    private String Telepon_Supplier;
    private String Nama_Barang;
    private Integer Qty_Min_Stock;
    private Integer Qty_Stock;
    private String Satuan;
    private Integer Harga_Barang;
}

