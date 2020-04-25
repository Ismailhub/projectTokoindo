package co.g2academy.indoapril_1.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ServiceMasterBarang {
    //Untuk Menampilkan Data All
//    List<ResponseMasterBarang> getMasterBarangList();

    Page<ModelMasterBarang> getMasterBarangList(Integer page, Integer limit);
}
