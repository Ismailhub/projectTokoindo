package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestPenjualan;
import co.g2academy.indoapril_1.request.RequestPenjualanTgl;
import co.g2academy.indoapril_1.response.ResponsePenjualan;

import java.util.List;

public interface ServicePenjualan {

    String create( List<RequestPenjualan> request );

    List<ResponsePenjualan> getOrderByTgl(RequestPenjualanTgl request );

}
