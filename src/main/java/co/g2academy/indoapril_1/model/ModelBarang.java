package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_barang")
@Entity
public class ModelBarang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idBarang;
    private String Nama_Barang;
    private Integer Qty_Min_Stock;
    private Integer Qty_Stock;
    private String Satuan;
    private Integer Harga_Barang;

//    private Integer Id_Supplier;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "Id_Supplier")
    private SupplierModel supplier;

}