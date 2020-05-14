package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.model.ModelSupplier;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositorySupplier;
import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import co.g2academy.indoapril_1.service.ServiceSupplier;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private RepositoryProduct repBarang;

    // menampilkan semua supplier
    @Override
    public List<ResponseSupplier> getSupplierList(Integer page, Integer limit){

        Pageable pageable = PageRequest.of(page,limit);

        return repository.findAll(pageable)
                .stream()
                .map(this::toResponseSupplierSimpel)
                .collect(Collectors.toList());

    }

    private ResponseSupplier toResponseSupplierSimpel( ModelSupplier entity ){

        return new ResponseSupplier(
                entity.getIdSupplier(),
                entity.getNamaSupplier(),
                entity.getAlamatSupplier(),
                entity.getTelepon()
        );
    }



    // menambah data supplier
    @Override
    @Transactional
    public boolean create( RequestSupplier request ){

        boolean dataExists = repository.existsByNamaSupplierAndAlamatSupplierAndTelepon( request.getNamaSupplier(), request.getAlamatSupplier(), request.getTelepon() );

        if( !dataExists ){

            ModelSupplier entity = toEntity( request );

            ModelSupplier saveEntity = repository.save( entity );

            return true;

        }else {

            return false;

        }


    }

    private ModelSupplier toEntity( RequestSupplier request ){

        return ModelSupplier
                .builder()
                .idSupplier( request.getIdSupplier() )
                .namaSupplier( request.getNamaSupplier() )
                .alamatSupplier( request.getAlamatSupplier() )
                .telepon( request.getTelepon() )
                .build();
    }


    @Override
    @Transactional
    public boolean edit( RequestSupplier request ){

        if( repository.findById( request.getIdSupplier() ) != null ){

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;

        }

    }


    // menampilkan supplier dan barangnya
    @Override
    public List<ResponseSupplierAndBarang> getSupplierAndBarangList(){

        return null;
//        return  repBarang.findAll()
//                .stream()
//                .map( this::toResponseSupplierAndBarangSimpel )
//                .collect( Collectors.toList() );

    }

    private ResponseSupplierAndBarang toResponseSupplierAndBarangSimpel( ModelProduct entity ){

        return null;
//        return new ResponseSupplierAndBarang(
//                entity.getSupplier().getId_Supplier(),
//                entity.getSupplier().getNama_Supplier(),
//                entity.getSupplier().getAlamat_Supplier(),
//                entity.getSupplier().getTelepon_Supplier(),
//                entity.getIdBarang(),
//                entity.getNama_Barang(),
//                entity.getQty_Min_Stock(),
//                entity.getQty_Stock(),
//                entity.getSatuan(),
//                entity.getHarga_Barang()
//        );

    }

}
