package co.g2academy.indoapril_1.service.impl;


import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceMasterBarang")
public class ServiceMasterBarangImpl implements ServiceMasterBarang {
    private RepositoryMasterBarang repository;

    //Menampilkan Data Master Barang All
//    @Override
//    public List<ResponseMasterBarang> getMasterBarangList() {
//        return repository.findAll().stream().map(this::toResponseMasterBarangSimple).collect(Collectors.toList());
//    }
//
//    private ResponseMasterBarang toResponseMasterBarangSimple(ModelMasterBarang entity){
//        return new ResponseMasterBarang(entity.getId_Barang(),
//                entity.getNama_Barang(),
//                entity.getNama_Suplier(),
//                entity.getStatus());
//
//    }

    @Override
    public Page<ModelMasterBarang> getMasterBarangList(Integer page, Integer limit) {
        Pageable pageable= PageRequest.of(page, limit);
        return repository.findAll(pageable);
    }

//    private ResponseMasterBarang toResponseMasterBarangSimple(ModelMasterBarang entity){
//        return new ResponseMasterBarang(entity.getId_Barang(),
//                entity.getNama_Barang(),
//                entity.getNama_Suplier(),
//                entity.getStatus());

}
