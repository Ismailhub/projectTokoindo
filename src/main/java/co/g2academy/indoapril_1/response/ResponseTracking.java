package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class ResponseTracking {

    private String idPenjualan;
    private Integer totalBayar;
    private String alamatTujuan;
    private String metodePembayaran;
    private String status;
    private Date tanggal;


    public ResponseTracking(
            String idPenjualan,
            Integer totalBayar,
            String alamatTujuan,
            String metodePembayaran,
            String status,
            Date tanggal
    ) {
        this.idPenjualan = idPenjualan;
        this.totalBayar = totalBayar;
        this.alamatTujuan = alamatTujuan;
        this.metodePembayaran = metodePembayaran;
        this.status = status;
        this.tanggal = tanggal;
    }

}
