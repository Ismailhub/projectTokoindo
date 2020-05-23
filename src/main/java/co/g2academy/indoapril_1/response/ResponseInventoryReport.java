package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
public class ResponseInventoryReport {

    @Id
    private int idProduct;
    private String namaProduct;
    private Integer qtyProductMasuk;
    private Integer qtyStock;
    private Integer qtyPenjualan;
    private Integer qtyMinStock;


    public ResponseInventoryReport(
            int idProduct,
            String namaProduct,
            Integer qtyProductMasuk,
            Integer qtyStock,
            Integer qtyPenjualan,
            Integer qtyMinStock
    ) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.qtyProductMasuk = qtyProductMasuk;
        this.qtyStock = qtyStock;
        this.qtyPenjualan = qtyPenjualan;
        this.qtyMinStock = qtyMinStock;
    }

    public int getIdProduct() {

        return this.idProduct;
    }

    public Integer getQtyPenjualan() {

        if(this.qtyPenjualan != null){

            return this.qtyPenjualan;

        }else {

            return 0;

        }
    }

    public Integer getQtyProductMasuk() {

        if(this.qtyProductMasuk != null){

            return this.qtyProductMasuk;

        }else {

            return 0;

        }

    }

    public Integer getQtyStock() {

        return this.qtyStock;

    }

    public String getNamaProduct() {

        return this.namaProduct;

    }

    public Integer getQtyMinStock() {

        return this.qtyMinStock;

    }

    public void setQtyProductMasuk( Integer qtyProductMasuk ) {

        this.qtyProductMasuk = qtyProductMasuk;

    }

    public void setQtyPenjualan( Integer qtyPenjualan ) {

        this.qtyPenjualan = qtyPenjualan;

    }

}