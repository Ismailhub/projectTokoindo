package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;

import java.util.List;

public interface ServiceSupplier {

    List<ResponseSupplier> getSupplierList();

    List<ResponseSupplierAndBarang> getSupplierAndBarangList();

    ResponseSupplier create( RequestSupplier request );
}
