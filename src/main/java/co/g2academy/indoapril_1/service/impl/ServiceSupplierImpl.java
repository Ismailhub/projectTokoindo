package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelBarang;
import co.g2academy.indoapril_1.model.SupplierModel;
import co.g2academy.indoapril_1.repository.RepositoryBarang;
import co.g2academy.indoapril_1.repository.RepositorySupplier;
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

    private RepositoryBarang repBarang;

    // menampilkan semua supplier
    @Override
    public List<ResponseSupplier> getSupplierList(){

        return repository.findAll()
                .stream()
                .map(this::toResponseSupplierSimpel)
                .collect(Collectors.toList());

    }

    private ResponseSupplier toResponseSupplierSimpel( SupplierModel entity ){

        return new ResponseSupplier(
                entity.getId_Supplier(),
                entity.getNama_Supplier(),
                entity.getAlamat_Supplier(),
                entity.getTelepon_Supplier()
        );
    }

    // menampilkan supplier dan barangnya
    @Override
    public List<ResponseSupplierAndBarang> getSupplierAndBarangList(){

        return  repBarang.findAll()
                .stream()
                .map( this::toResponseSupplierAndBarangSimpel )
                .collect( Collectors.toList() );

    }

    private ResponseSupplierAndBarang toResponseSupplierAndBarangSimpel( ModelBarang entity ){

        return new ResponseSupplierAndBarang(
                entity.getSupplier().getId_Supplier(),
                entity.getSupplier().getNama_Supplier(),
                entity.getSupplier().getAlamat_Supplier(),
                entity.getSupplier().getTelepon_Supplier(),
                entity.getIdBarang(),
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
    public ResponseSupplier create( RequestSupplier request ){

        SupplierModel entity = toEntity( request );

        SupplierModel saveEntity = repository.save( entity );

        return toResponseSupplierSimpel( saveEntity );

    }

    private SupplierModel toEntity( RequestSupplier request ){

        return SupplierModel
                .builder()
                .Id_Supplier(request.getId_Supplier())
                .Nama_Supplier(request.getNama_Supplier())
                .Alamat_Supplier(request.getAlamat_Supplier())
                .Telepon_Supplier(request.getTelepon_Supplier())
                .build();

    }

}
