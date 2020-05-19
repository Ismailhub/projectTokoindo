package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.model.ModelProduct;
import co.g2academy.indoapril_1.request.RequestProduct;
import co.g2academy.indoapril_1.response.ResponseProduct;

import java.util.List;

public interface ServiceProduct {

    boolean create( RequestProduct request );

    boolean edit( RequestProduct request );

    List<ResponseProduct> getProducts(Integer page, Integer limit);

    List<ModelProduct> getCekMinStock();
}
