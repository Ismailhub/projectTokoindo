package co.g2academy.indoapril_1.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ResponseBarangMasuk {
    private int Id_Barang_Masuk;
    private String Nomor_Surat_Jalan;
    private String Nama_Barang;
    private String Nama_Supplier;
    private Integer Qtt_Barang_Masuk;
    private String Tanggal_Pemesanan;
    private String Tanggal_Masuk;

    public ResponseBarangMasuk(int id_barang_masuk,
                               String nomor_surat_jalan,
                               String nama_barang,
                               String nama_supplier,
                               Integer qtt_barang_masuk,
                               String tanggal_pemesanan,
                               String tanggal_masuk
                               ) {
        this.Id_Barang_Masuk = id_barang_masuk;
        this.Nomor_Surat_Jalan = nomor_surat_jalan;
        this.Nama_Barang = nama_barang;
        this.Nama_Supplier = nama_supplier;
        this.Qtt_Barang_Masuk = qtt_barang_masuk;
        this.Tanggal_Pemesanan = tanggal_pemesanan;
        this.Tanggal_Masuk = tanggal_masuk;
    }
}
