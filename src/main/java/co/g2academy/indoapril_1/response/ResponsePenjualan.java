package co.g2academy.indoapril_1.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponsePenjualan {

    private String idPenjualan;
    private Integer totalBayar;
    private String statusPembayaran;
    private Date tanggalPenjualan;
    private Integer idCustomer;
    private String namaProduct;
    private Integer qtyPenjualan;
    private Integer subTotal;
    private Integer subKeuntungan;


    public ResponsePenjualan(
            String idPenjualan,
            Integer totalBayar,
            String statusPembayaran,
            Date tanggalPenjualan,
            Integer idCustomer,
            String namaProduct,
            Integer qtyPenjualan,
            Integer subTotal,
            Integer subKeuntungan
    ) {
        this.idPenjualan = idPenjualan;
        this.totalBayar = totalBayar;
        this.statusPembayaran = statusPembayaran;
        this.tanggalPenjualan = tanggalPenjualan;
        this.idCustomer = idCustomer;
        this.namaProduct = namaProduct;
        this.qtyPenjualan = qtyPenjualan;
        this.subTotal = subTotal;
        this.subKeuntungan = subKeuntungan;
    }

}