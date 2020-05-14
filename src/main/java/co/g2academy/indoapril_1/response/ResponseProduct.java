package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
public class ResponseProduct {

    private Integer idProduct;
    private String namaProduct;
    private String merek;
    private Integer qtyMinStock;
    private Integer qtyStock;
    private Integer hargaBeli;
    private Integer hargaJual;
    private String kategori;
    private String gambar;
    private String ukuran;
    private String rasa;
    private String isiPerkarton;
    private String deskripsi;
    private Integer idSupplier;

    public ResponseProduct(
            Integer idProduct,
            String namaProduct,
            String merek,
            Integer qtyMinStock,
            Integer qtyStock,
            Integer hargaBeli,
            Integer hargaJual,
            String kategori,
            String gambar,
            String ukuran,
            String rasa,
            String isiPerkarton,
            String deskripsi,
            Integer idSupplier
    ) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.merek = merek;
        this.qtyMinStock = qtyMinStock;
        this.qtyStock = qtyStock;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.kategori = kategori;
        this.gambar = gambar;
        this.ukuran = ukuran;
        this.rasa = rasa;
        this.isiPerkarton = isiPerkarton;
        this.deskripsi = deskripsi;
        this.idSupplier = idSupplier;
    }

}
