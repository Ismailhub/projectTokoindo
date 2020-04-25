package com.example.indoapril.service;

import com.example.indoapril.model.ModelBarangMasuk;
import com.example.indoapril.repository.RepositoryBarangMasuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BarangMasukService {
    @Autowired
    private RepositoryBarangMasuk repo;

    //lihat keseluruhan data
    public List<ModelBarangMasuk> listAll(){
        return repo.findAll();
    }

    public void save(ModelBarangMasuk tb_barang_masuk){
        repo.save(tb_barang_masuk);
    }

    public ModelBarangMasuk get(Integer id_barang_masuk){
        return repo.findById(id_barang_masuk).get();
    }


}
