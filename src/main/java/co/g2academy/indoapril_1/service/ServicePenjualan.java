package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestPenjualan;
import co.g2academy.indoapril_1.request.RequestSetStatusPembayaran;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.ResponseDataSales;
import co.g2academy.indoapril_1.response.ResponseKonfirmasiPembayaran;
import co.g2academy.indoapril_1.response.ResponsePenjualan;

import java.util.List;

public interface ServicePenjualan {

    List<ResponsePenjualan> getOrderByTgl(RequestTanggal request );

    List<ResponseDataSales> getDataSales(RequestTanggal request);

    List<ResponseKonfirmasiPembayaran> getStatusBayar();

    void setStatusPembayaran( RequestSetStatusPembayaran request );
}
