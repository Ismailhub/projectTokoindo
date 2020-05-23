package co.g2academy.indoapril_1.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor

public class ResponseSupplierAndProducts {

    private Integer idSupplier;
    private String namaSupplier;
    private String telepon;
    private Integer idProduct;
    private String namaProduct;
    private Integer qtyMinStock;
    private Integer qtyStock;
    private Integer hargaBeli;
    private Integer hargaJual;


    public ResponseSupplierAndProducts(
            Integer idSupplier,
            String namaSupplier,
            String telepon,
            Integer idProduct,
            String namaProduct,
            Integer qtyMinStock,
            Integer qtyStock,
            Integer hargaBeli,
            Integer hargaJual
    ) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.telepon = telepon;
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.qtyMinStock = qtyMinStock;
        this.qtyStock = qtyStock;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
    }

}