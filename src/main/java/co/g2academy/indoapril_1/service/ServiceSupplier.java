package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndProducts;

import java.util.List;

public interface ServiceSupplier {

    List<ResponseSupplier> getSupplierList(Integer page, Integer limit);

    List<ResponseSupplierAndProducts> getSupplierAndProductList();

    boolean create( RequestSupplier request );

    boolean edit( RequestSupplier request );

}
