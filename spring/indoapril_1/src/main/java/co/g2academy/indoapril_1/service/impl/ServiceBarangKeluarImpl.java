package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelBarangKeluar;
import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import co.g2academy.indoapril_1.repository.RepositoryBarangMasuk;
import co.g2academy.indoapril_1.request.RequestBarangKeluar;
import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangKeluar;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import co.g2academy.indoapril_1.service.ServiceBarangKeluar;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("SeviceBarangKeluar")
public class ServiceBarangKeluarImpl implements ServiceBarangKeluar {
    private RepositoryBarangKeluar repository;

    //Menampilkan Data
    @Override
    public List<ResponseBarangKeluar> getBarangKeluarList() {
        return repository.findAll().stream().map(this::toResponseBarangKeluarSimple).collect(Collectors.toList());
    }
    private ResponseBarangKeluar toResponseBarangKeluarSimple(ModelBarangKeluar entity){
        return new ResponseBarangKeluar(entity.getId_Barang_Keluar(),
                entity.getId_Barang(),
                entity.getNama_Barang(),
                entity.getQtt_Barang_Keluar(),
                entity.getTanggal_Keluar());
    }

    //Menambah Data Barang Masuk
    @Override
    @Transactional
    public ResponseBarangKeluar create(RequestBarangKeluar request){
        ModelBarangKeluar entity = toEntity(request);
        ModelBarangKeluar saveEntity = repository.save(entity);
        return toResponseBarangKeluarSimple(saveEntity);
    }
    private  ModelBarangKeluar toEntity(RequestBarangKeluar request){
        return ModelBarangKeluar.builder()
                .Id_Barang_Keluar(request.getId_Barang_Keluar())
                .Id_Barang(request.getId_Barang())
                .Nama_Barang(request.getNama_Barang())
                .Qtt_Barang_Keluar(request.getQtt_Barang_Keluar())
                .Tanggal_Keluar(request.getTanggal_Keluar())
                .build();
    }


}
