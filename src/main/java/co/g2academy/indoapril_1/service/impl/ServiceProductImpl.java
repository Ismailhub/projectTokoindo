package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.model.ModelProductMasuk;
import co.g2academy.indoapril_1.repository.RepositoryProduct;
import co.g2academy.indoapril_1.repository.RepositoryProductMasuk;
import co.g2academy.indoapril_1.repository.RepositorySupplier;
import co.g2academy.indoapril_1.request.RequestProduct;
import co.g2academy.indoapril_1.response.ResponseProduct;
import co.g2academy.indoapril_1.service.ServiceProduct;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("ServiceProduct")
public class ServiceProductImpl implements ServiceProduct {

    @Autowired
    private RepositoryProduct repository;

    @Autowired
    private RepositorySupplier repositorySupplier;

    @Autowired
    private RepositoryProductMasuk repositoryProductMasuk;

    public boolean create( RequestProduct request ){

        boolean existsName = repository.existsByNamaProduct( request.getNamaProduct() );

        boolean existsSupplier = repositorySupplier.existsById( request.getIdSupplier() );

        if ( !existsName && existsSupplier ){

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;
        }

    }

    public ResponseProduct saveGambar( Integer idProduct, MultipartFile file ) throws IOException, SQLException {

        ModelProduct dataProduct = repository.findByIdProduct(idProduct);

        System.out.println(dataProduct);

        dataProduct.setGambar( toBlob(file) );

        repository.save(dataProduct);

        return toResponseProductSimpel(dataProduct);

    }

    private Blob toBlob(MultipartFile file) throws IOException, SQLException {

        byte[] bytes = file.getBytes();

        return new SerialBlob(bytes);

    }

    private String toBase64( Blob imageBlob ) throws SQLException {

        if ( imageBlob != null ){

            try {

                int blobLength = (int) imageBlob.length();

                byte[] byteImage = imageBlob.getBytes(1, blobLength);

                return Base64.encodeBase64String(byteImage);

            }catch (Exception e){

                System.out.println(e);

            }

        }

        return null;

    }

    private ModelProduct toEntity( RequestProduct request ){

        return ModelProduct.builder()
                .idProduct( request.getIdProduct() )
                .namaProduct( request.getNamaProduct() )
                .merek( request.getMerek() )
                .qtyMinStock( request.getQtyMinStock() )
                .qtyStock( request.getQtyStock() )
                .hargaBeli( request.getHargaBeli() )
                .hargaJual( request.getHargaJual() )
                .kategori( request.getKategori() )
                .gambar( null )
                .ukuran( request.getUkuran() )
                .rasa( request.getRasa() )
                .isiPerkarton( request.getIsiPerkarton() )
                .deskripsi( request.getDeskripsi() )
                .idSupplier( request.getIdSupplier() )
                .build();

    }

    public List<ResponseProduct> getProducts(Integer page, Integer limit){

        Pageable pageable = PageRequest.of(page,limit);

        return repository.findAll(pageable).stream().map(this::toResponseProductSimpel).collect(Collectors.toList());

    }

    private ResponseProduct toResponseProductSimpel( ModelProduct entity ) {

        String imageBase64 = new String();

        try {

            imageBase64 = "data:image/png;base64, "+toBase64(entity.getGambar());

        }catch (Exception e){

            System.out.println(e);

        }

        return new ResponseProduct(
                entity.getIdProduct(),
                entity.getNamaProduct(),
                entity.getMerek(),
                entity.getQtyMinStock(),
                entity.getQtyStock(),
                entity.getHargaBeli(),
                entity.getHargaJual(),
                entity.getKategori(),
                imageBase64,
                entity.getUkuran(),
                entity.getRasa(),
                entity.getIsiPerkarton(),
                entity.getDeskripsi(),
                entity.getIdSupplier()
        );
    }

    public boolean edit( RequestProduct request ){

        ModelProduct dataProduct = repository.findByIdProduct( request.getIdProduct() );

        if ( dataProduct != null ){

            Integer stockProduct = dataProduct.getQtyStock();

            request.setQtyStock( stockProduct );

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;

        }
    }


    public List<ResponseProduct> getCekMinStock(){

        return repository.findAll().stream().filter(data -> data.getQtyStock() < data.getQtyMinStock()).map(this::toResponseProductSimpel).collect(Collectors.toList());

    }

    public boolean productIsExsistById(Integer idProduct){

        return repository.existsById(idProduct);

    }

}