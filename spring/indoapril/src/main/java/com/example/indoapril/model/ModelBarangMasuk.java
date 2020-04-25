package com.example.indoapril.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@Table(name =  "tb_barang_masuk")//adalah tabel data base clien
@Entity
@EntityListeners(AuditingEntityListener.class)

public class ModelBarangMasuk {
    private Integer id_barang_masuk;
    private String nomor_surat_jalan;
    private String tanggal_pemesanan;
    private String tangggal_masuk;
    private int id_barang;
    private int qtt_barang_masuk;
    private int suplier;

    public void ModelBarangMasuk() {
    }

    public ModelBarangMasuk(Integer id_barang_masuk,
                            String nomor_surat_jalan,
                            String tanggal_pemesanan,
                            String tangggal_masuk,
                            int id_barang,
                            int qtt_barang_masuk,
                            int suplier) {
        this.id_barang_masuk = id_barang_masuk;
        this.nomor_surat_jalan = nomor_surat_jalan;
        this.tanggal_pemesanan = tanggal_pemesanan;
        this.tangggal_masuk = tangggal_masuk;
        this.id_barang = id_barang;
        this.qtt_barang_masuk = qtt_barang_masuk;
        this.suplier = suplier;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id_barang_masuk;
    }

    // other getters and setters...
}
