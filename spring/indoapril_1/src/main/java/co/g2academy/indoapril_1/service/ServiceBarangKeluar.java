package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestBarangKeluar;
import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangKeluar;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;

import java.util.List;

public interface ServiceBarangKeluar {
    //Tampilkan Data
    List<ResponseBarangKeluar> getBarangKeluarList();

    //Tambah Data Barang Keluar:
    ResponseBarangKeluar create(RequestBarangKeluar request);
}
