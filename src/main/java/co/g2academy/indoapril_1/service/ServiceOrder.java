package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestOrder;
import co.g2academy.indoapril_1.request.RequestOrderTgl;
import co.g2academy.indoapril_1.response.ResponseOrder;

import java.util.List;

public interface ServiceOrder {

    String create( List<RequestOrder> request );

    List<ResponseOrder> getOrderByTgl( RequestOrderTgl request );

}
