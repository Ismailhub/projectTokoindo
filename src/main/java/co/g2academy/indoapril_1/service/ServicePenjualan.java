package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.model.ModelRefund;
import co.g2academy.indoapril_1.model.ModelRefundStatus;
import co.g2academy.indoapril_1.request.RequestIdPenjualan;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseDataSales;
import co.g2academy.indoapril_1.response.ResponseKonfirmasiPembayaran;
import co.g2academy.indoapril_1.response.ResponsePenjualan;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;

import java.util.List;

public interface ServicePenjualan {

    List<ResponsePenjualan> getOrderByTgl(RequestTanggal request );

    List<ResponseDataSales> getDataSales(RequestTanggal request);

    List<ResponseKonfirmasiPembayaran> getStatusBayar();

    boolean setStatusTransaksi( RequestIdPenjualan request );

    BaseResponse getTracking( String idPenjualan );

    List<ModelRefundStatus> getRefundStatus();

    ModelRefundStatus setRefundStatus(String idPenjualan, String isDisetujui);

    List<ModelRefund> getRefund();

    ModelRefund setRefund(Integer idRefundStatus);

}
