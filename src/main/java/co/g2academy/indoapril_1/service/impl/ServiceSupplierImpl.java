package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelSupplairAndBarang;
import co.g2academy.indoapril_1.model.SupplierModel;
import co.g2academy.indoapril_1.repository.RepositorySupplier;
import co.g2academy.indoapril_1.repository.RepositorySupplierAndBarang;
import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import co.g2academy.indoapril_1.service.ServiceSupplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceSupplier")
public class ServiceSupplierImpl implements ServiceSupplier {
    private RepositorySupplier repository;
    private RepositorySupplierAndBarang repositorySNB;

    // menampilkan semua supplier
    @Override
    public List<ResponseSupplier> getSupplierList(){
        return repository.findAll().stream().map(this::toResponseSupplierSimpel).collect(Collectors.toList());
    }
    private ResponseSupplier toResponseSupplierSimpel(SupplierModel entity){
        return new ResponseSupplier(entity.getId_Supplier(),
                entity.getNama_Supplier(),
                entity.getAlamat_Supplier(),
                entity.getKota_Supplier(),
                entity.getProvinsi_Supplier(),
                entity.getTelepon_Supplier(),
                entity.getStatus()
        );
    }

    @Override
    public List<ResponseSupplierAndBarang> getSupplierAndBarangList(){

        return  repositorySNB.getSupplierAndBarangList().stream().map(this::toResponseSupplierAndBarangSimpel).collect(Collectors.toList());
    }
    private ResponseSupplierAndBarang toResponseSupplierAndBarangSimpel(ModelSupplairAndBarang entity){
        System.out.println("entity = "+entity);
        return new ResponseSupplierAndBarang(
                entity.getId_Supplier(),
                entity.getNama_Supplier(),
                entity.getAlamat_Supplier(),
                entity.getTelepon_Supplier(),
                entity.getId_Barang(),
                entity.getNama_Barang(),
                entity.getQty_Min_Stock(),
                entity.getQty_Stock(),
                entity.getSatuan(),
                entity.getHarga_Barang()
        );
    }

    // menambah data supplier
    @Override
    @Transactional
    public ResponseSupplier create(RequestSupplier request){
        System.out.println(request);
        SupplierModel entity = toEntity(request);
        SupplierModel saveEntity = repository.save(entity);
        return toResponseSupplierSimpel(saveEntity);
    }
    private SupplierModel toEntity(RequestSupplier request){
        return SupplierModel.builder()
                .Id_Supplier(request.getId_Supplier())
                .Nama_Supplier(request.getNama_Supplier())
                .Alamat_Supplier(request.getAlamat_Supplier())
                .Kota_Supplier(request.getKota_Supplier())
                .Provinsi_Supplier(request.getProvinsi_Supplier())
                .Telepon_Supplier(request.getTelepon_Supplier())
                .Status(request.getStatus())
                .build();
    }

}
