package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestProductMasuk;
import co.g2academy.indoapril_1.response.ResponseProductMasuk;

import java.util.List;

public interface ServiceProductMasuk {

    //Untuk Menampilkan Data Barang Masuk All
    List<ResponseProductMasuk> getProductMasukList();

    //Tambah Data Barang Masuk
    void create( List<RequestProductMasuk> request );

    boolean findIdProduct( Integer idBarang );

}
