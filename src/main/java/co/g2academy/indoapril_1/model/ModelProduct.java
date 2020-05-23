package co.g2academy.indoapril_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
@Entity
public class ModelProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProduct;
    private String namaProduct;
    private String merek;
    private Integer qtyMinStock;
    private Integer qtyStock;
    private Integer hargaBeli;
    private Integer hargaJual;
    private String kategori;
    @Lob
    private Blob gambar;
    private String ukuran;
    private String rasa;
    private String isiPerkarton;
    private String deskripsi;
    private Integer idSupplier;


    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "idSupplier",
            insertable = false,
            updatable = false
    )
    private ModelSupplier supplier;


    public Integer getIdProduct() {

        return idProduct;

    }

    public void setQtyStock( Integer qtyStock ) {

        this.qtyStock += qtyStock;

    }

    public void reduceQtyStock( Integer qtyStock ) {

        this.qtyStock -= qtyStock;

    }

    public Integer getQtyStock() {

        return qtyStock;

    }

    public Blob getGambar() {

        return gambar;

    }

    public void setGambar( Blob gambar ) {

        this.gambar = gambar;

    }

}