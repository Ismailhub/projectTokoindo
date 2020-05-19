package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.model.ModelProductMasuk;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositoryProductMasuk;
import co.g2academy.indoapril_1.request.RequestProductMasuk;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseProductMasuk;
import co.g2academy.indoapril_1.service.ServiceProductMasuk;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("SeviceBarangMasuk")
public class ServiceProductMasukImpl implements ServiceProductMasuk {

    private RepositoryProduct repositoryProduct;

    private RepositoryProductMasuk repository;

    //Menambah Data Barang Masuk
    @Transactional
    public void create( List<RequestProductMasuk> request ){

        for ( RequestProductMasuk dataMasuk : request ){

            ModelProductMasuk entity = toEntity( dataMasuk );

            repository.save( entity );

            ModelProduct product = repositoryProduct.findByIdProduct( dataMasuk.getIdProduct() );

            product.setQtyStock( dataMasuk.getQtyMasuk() );

            repositoryProduct.save( product );

        }

    }

    private ModelProductMasuk toEntity( RequestProductMasuk request ){

        return ModelProductMasuk.builder()
                .idProductMasuk( null )
                .qtyMasuk( request.getQtyMasuk() )
                .tanggalMasuk( request.getTanggalMasuk() )
                .idProduct( request.getIdProduct() )
                .build();
    }

    //Menampilkan Data Barang Masuk All
    @Override
    public List<ResponseProductMasuk> getProductMasukList() {

        return repository.findAll()
                .stream()
                .map(this::toResponseProductMasukSimple)
                .collect(Collectors.toList());
    }

    private ResponseProductMasuk toResponseProductMasukSimple( ModelProductMasuk entity ){

        return new ResponseProductMasuk(
        entity.getIdProductMasuk(),
        entity.getQtyMasuk(),
        entity.getTanggalMasuk(),
        entity.getIdProduct()
        );

    }

    public boolean findIdProduct( Integer idBarang ){

        if( repositoryProduct.findByIdProduct( idBarang ) != null ){

            System.out.println("barang ada");

            return true;

        }else {

            System.out.println("barang tidak ada");

            return false;

        }

    }
}