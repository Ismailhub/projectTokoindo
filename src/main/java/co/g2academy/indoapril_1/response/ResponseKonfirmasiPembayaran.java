package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Blob;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
public class ResponseKonfirmasiPembayaran {

    private String idPenjualan;
    private Integer totalPenjualan;
    private Integer totalBayar;
    private String alamatTujuan;
    private String metodePembayaran;
    private Date tanggalPenjualan;
    private Integer idCustomer;
    private byte[] gambarBuktiTransfer;


    public ResponseKonfirmasiPembayaran(
            String idPenjualan,
            Integer totalPenjualan,
            Integer totalBayar,
            String alamatTujuan,
            String metodePembayaran,
            Date tanggalPenjualan,
            Integer idCustomer,
            byte[] gambarBuktiTransfer
    ) {
        this.idPenjualan = idPenjualan;
        this.totalPenjualan = totalPenjualan;
        this.totalBayar = totalBayar;
        this.alamatTujuan = alamatTujuan;
        this.metodePembayaran = metodePembayaran;
        this.tanggalPenjualan = tanggalPenjualan;
        this.idCustomer = idCustomer;
        this.gambarBuktiTransfer = gambarBuktiTransfer;
    }

}
