package co.g2academy.indoapril_1.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
public class ResponseBarangMasuk {

    private int Id_Barang_Masuk;
    private String Nomor_Surat_Jalan;
    private Integer Id_Barang;
    private Integer Qtt_Barang_Masuk;
    private Date Tanggal_Pemesanan;
    private Date Tanggal_Masuk;
    private String Nama_Barang;

    public ResponseBarangMasuk(
            int Id_Barang_Masuk,
            String nomor_surat_jalan,
            Integer Id_Barang,
            Integer qtt_barang_masuk,
            Date tanggal_pemesanan,
            Date tanggal_masuk,
            String nama_Barang
    ) {
        this.Id_Barang_Masuk = Id_Barang_Masuk;
        this.Nomor_Surat_Jalan = nomor_surat_jalan;
        this.Id_Barang = Id_Barang;
        this.Qtt_Barang_Masuk = qtt_barang_masuk;
        this.Tanggal_Pemesanan = tanggal_pemesanan;
        this.Tanggal_Masuk = tanggal_masuk;
        this.Nama_Barang = nama_Barang;
    }

}
