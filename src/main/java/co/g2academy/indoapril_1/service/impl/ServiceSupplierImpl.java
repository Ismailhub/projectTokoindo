package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.model.ModelSupplier;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositorySupplier;
import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndProducts;
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

    private RepositoryProduct repProduct;


    /*
     *
     * @Fungsi Menampilkan Semua Supplier
     *
     */
    @Override
    public List<ResponseSupplier> getSupplierList(Integer page, Integer limit){

        Pageable pageable = PageRequest.of(page,limit);

        return repository.findAll(pageable)
                .stream()
                .map(this::toResponseSupplierSimpel)
                .collect(Collectors.toList());

    }


    /*
     *
     * @Fungsi Untuk Menambah Data Supplier
     *
     */
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


    /*
     *
     * @Fungsi Mengubah Data Supplier
     *
     */
    @Override
    @Transactional
    public boolean edit( RequestSupplier request ){

        if( repository.existsByIdSupplier(request.getIdSupplier()) ){

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;

        }

    }



    /*
     *
     * @Fungsi Menampilkan List Barang dan Suppliernya
     *
     */
    @Override
    public List<ResponseSupplierAndProducts> getSupplierAndProductList(){

        return repProduct.findAll()
                .stream()
                .map( this::toResponseSupplierAndProductSimpel )
                .collect( Collectors.toList() );

    }


    /*
     *
     * @Fungsi Untuk Helper
     *
     */

    private ResponseSupplierAndProducts toResponseSupplierAndProductSimpel( ModelProduct entity ){

        return new ResponseSupplierAndProducts(
                entity.getSupplier().getIdSupplier(),
                entity.getSupplier().getNamaSupplier(),
                entity.getSupplier().getTelepon(),
                entity.getIdProduct(),
                entity.getNamaProduct(),
                entity.getQtyMinStock(),
                entity.getQtyStock(),
                entity.getHargaBeli(),
                entity.getHargaJual()
        );

    }

    private ResponseSupplier toResponseSupplierSimpel( ModelSupplier entity ){

        return new ResponseSupplier(
                entity.getIdSupplier(),
                entity.getNamaSupplier(),
                entity.getAlamatSupplier(),
                entity.getTelepon()
        );
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

}
