package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestOrder;
import co.g2academy.indoapril_1.response.ResponseOrder;

import java.util.List;

public interface ServiceOrder {
    ResponseOrder create(List<RequestOrder> request);

}
