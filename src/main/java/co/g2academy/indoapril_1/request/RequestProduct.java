package co.g2academy.indoapril_1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduct {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
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

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public String getMerek() {
        return merek;
    }

    public Integer getQtyMinStock() {
        return qtyMinStock;
    }

    public Integer getQtyStock() {
        return qtyStock;
    }

    public Integer getHargaBeli() {
        return hargaBeli;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public String getKategori() {
        return kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public String getUkuran() {
        return ukuran;
    }

    public String getRasa() {
        return rasa;
    }

    public String getIsiPerkarton() {
        return isiPerkarton;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setQtyStock(Integer qtyStock) {

        this.qtyStock = qtyStock;

    }

}
