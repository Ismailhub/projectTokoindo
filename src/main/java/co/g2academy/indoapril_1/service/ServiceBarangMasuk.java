package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;

import java.util.List;

public interface ServiceBarangMasuk {

    //Untuk Menampilkan Data Barang Masuk All
    List<ResponseBarangMasuk> getBarangMasukList();

    //Tambah Data Barang Masuk
    ResponseBarangMasuk create( RequestBarangMasuk request );

    boolean findIdBarang( Integer idBarang );

}
