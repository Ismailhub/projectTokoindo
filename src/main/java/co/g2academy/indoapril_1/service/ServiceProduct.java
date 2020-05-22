package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.request.RequestProduct;
import co.g2academy.indoapril_1.response.ResponseProduct;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ServiceProduct {

    boolean create( RequestProduct request );

    boolean edit( RequestProduct request );

    List<ResponseProduct> getProducts(Integer page, Integer limit);

    List<ModelProduct> getCekMinStock();

    ResponseProduct saveGambar( Integer idProduct, MultipartFile file ) throws IOException, SQLException;

    boolean productIsExsistById( Integer idProduct );

}
