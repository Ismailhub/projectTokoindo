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
public class RequestBarangMasuk {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Barang_Masuk;
    private String Nomor_Surat_Jalan;
    private String Nama_Barang;
    private String Nama_Supplier;
    private Integer Qtt_Barang_Masuk;
    private String Tanggal_Pemesanan;
    private String Tanggal_Masuk;
}
