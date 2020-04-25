package co.g2academy.indoapril_1.service.impl;


import co.g2academy.indoapril_1.model.ModelBarangMasuk;
import co.g2academy.indoapril_1.repository.RepositoryBarangMasuk;
import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("SeviceBarangMasuk")
public class ServiceBarangMasukImpl implements ServiceBarangMasuk {
    private RepositoryBarangMasuk repository;

    //Menampilkan Data Barang Masuk All
    @Override
    public List<ResponseBarangMasuk> getBarangMasukList() {
        return repository.findAll().stream().map(this::toResponseBarangMasukSimple).collect(Collectors.toList());
    }
    private ResponseBarangMasuk toResponseBarangMasukSimple(ModelBarangMasuk entity){
        return new ResponseBarangMasuk(entity.getId_Barang_Masuk(),
                entity.getNomor_Surat_Jalan(),
                entity.getNama_Barang(),
                entity.getNama_Supplier(),
                entity.getQtt_Barang_Masuk(),
                entity.getTanggal_Pemesanan(),
                entity.getTanggal_Masuk());
    }

    //Menambah Data Barang Masuk
    @Override
    @Transactional
    public ResponseBarangMasuk create(RequestBarangMasuk request){
        ModelBarangMasuk entity = toEntity(request);
        ModelBarangMasuk saveEntity = repository.save(entity);
        return toResponseBarangMasukSimple(saveEntity);
    }
    private  ModelBarangMasuk toEntity(RequestBarangMasuk request){
        return ModelBarangMasuk.builder()
                .Nomor_Surat_Jalan(request.getNomor_Surat_Jalan())
                .Nama_Barang(request.getNama_Barang())
                .Nama_Supplier(request.getNama_Supplier())
                .Qtt_Barang_Masuk(request.getQtt_Barang_Masuk())
                .Tanggal_Pemesanan(request.getTanggal_Pemesanan())
                .Tanggal_Masuk(request.getTanggal_Masuk())
                .build();
    }
}

