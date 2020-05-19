package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestSetStatusPembayaran;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceProductMasuk;
import co.g2academy.indoapril_1.service.ServicePenjualan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("penjualan")
public class PenjualanController {

    @Autowired
    ServicePenjualan service;

    @Autowired
    ServiceProductMasuk serviceProductMasuk;

    //lihat order by tgl
    @PostMapping(
            value = "/getPenjualan",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getPenjualan( @RequestBody RequestTanggal request ){

        Date tanggalAwal = request.getTgl();

        Date tanggalAkhir = request.getTglAkhir();

        Integer hasilPerbandingan = tanggalAwal.compareTo(tanggalAkhir);

        if ( hasilPerbandingan <= 0 ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "OK", service.getOrderByTgl(request), " Data Seluruh Penjualan dan Pesanan " );

            return new ResponseEntity<>( baseResponse, HttpStatus.OK );


        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request , " Tanggal tidak valid " );

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

    //lihat data sales
    @PostMapping(
            value = "/getDataSales",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getDataSales( @RequestBody RequestTanggal request ){

        Date tanggalAwal = request.getTgl();

        Date tanggalAkhir = request.getTglAkhir();

        Integer hasilPerbandingan = tanggalAwal.compareTo(tanggalAkhir);

        if ( hasilPerbandingan <= 0 ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "200",service.getDataSales(request)," Data Sales/Transaksi dan Keuntungan");

            return new ResponseEntity<>(baseResponse,HttpStatus.OK);

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request , " Tanggal tidak valid " );

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

    @GetMapping("/getStatusPembayaran")
    public ResponseEntity<BaseResponse> getStatusPembayaran(){

        BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "200",service.getStatusBayar()," Data Status Pembayaran ");

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }

    @PostMapping(
            value = "/setStatusPembayaran",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> setStatusPembayaran( @RequestBody RequestSetStatusPembayaran request ){

        service.setStatusPembayaran( request );

        BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "200",request," Status pembayaran berhasil dirubah ");

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }

}