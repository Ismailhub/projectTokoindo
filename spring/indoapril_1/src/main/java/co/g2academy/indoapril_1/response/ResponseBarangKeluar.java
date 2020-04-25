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
public class ResponseBarangKeluar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id_Barang_Keluar;
    private Integer Id_Barang;
    private String Nama_Barang;
    private Integer Qtt_Barang_Keluar;
    private String Tanggal_Keluar;

    public ResponseBarangKeluar(int id_barang_keluar,
                                Integer id_barang,
                                String nama_Barang,
                                Integer qtt_barang_keluar,
                                String tanggal_keluar
    ) {
        this.Id_Barang_Keluar = id_barang_keluar;
        this.Id_Barang = id_barang;
        this.Nama_Barang = nama_Barang;
        this.Qtt_Barang_Keluar = qtt_barang_keluar;
        this.Tanggal_Keluar = tanggal_keluar;
    }
}
