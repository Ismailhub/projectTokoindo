package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.model.ModelProductMasuk;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositoryProductMasuk;
import co.g2academy.indoapril_1.request.RequestProductMasuk;
import co.g2academy.indoapril_1.response.ResponseProductMasuk;
import co.g2academy.indoapril_1.service.ServiceProductMasuk;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Repository("SeviceBarangMasuk")
public class ServiceProductMasukImpl implements ServiceProductMasuk {

    private RepositoryProduct repositoryProduct;

    private RepositoryProductMasuk repository;


    /*
     *
     * @Fungsi Menambah Stock Product
     *
     */
    @Transactional
    public void create( List<RequestProductMasuk> request ){

        for ( RequestProductMasuk dataMasuk : request ){

            ModelProduct product = repositoryProduct.findByNamaProduct( dataMasuk.getNamaProduct() );

            product.setQtyStock( dataMasuk.getQtyMasuk() );

            ModelProductMasuk entity = toEntity( dataMasuk , product.getIdProduct() );

            repositoryProduct.save( product );

            repository.save( entity );

        }

    }


    /*
     *
     * @Fungsi Menampilkan Semua Product
     *
     */
    @Override
    public List<ResponseProductMasuk> getProductMasukList() {

        return repository.findAll()
                .stream()
                .map(this::toResponseProductMasukSimple)
                .collect(Collectors.toList());
    }


    /*
     *
     * @Fungsi - Fungsi Untuk Helper
     *
     */

    private ResponseProductMasuk toResponseProductMasukSimple( ModelProductMasuk entity ){

        return new ResponseProductMasuk(
                entity.getIdProductMasuk(),
                entity.getQtyMasuk(),
                entity.getTanggalMasuk(),
                entity.getIdProduct()
        );

    }

    public boolean findNamaProduct( String namaProduct ){

        if( repositoryProduct.findByNamaProduct( namaProduct ) != null ){

            System.out.println("barang ada");

            return true;

        }else {

            System.out.println("barang tidak ada");

            return false;

        }

    }

    private ModelProductMasuk toEntity( RequestProductMasuk request, Integer idProduct ){

        return ModelProductMasuk.builder()
                .idProductMasuk( null )
                .qtyMasuk( request.getQtyMasuk() )
                .tanggalMasuk( request.getTanggalMasuk() )
                .idProduct( idProduct )
                .build();
    }


}