package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestIdPenjualan;
import co.g2academy.indoapril_1.request.RequestRefundStatus;
import co.g2academy.indoapril_1.request.RequestSetRefund;
import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
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

    @Autowired
    ServiceAdmin autentikasi;


    /*
     *
     * @Untuk Menampilkan Penjualan By Tanggal
     *
     */
    @PostMapping(
            value = "/getPenjualan",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getPenjualan( @RequestBody RequestTanggal request,
                                                      @RequestHeader(required = false) String token
    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        request,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        Date tanggalAwal = request.getTgl();

        Date tanggalAkhir = request.getTglAkhir();

        Integer hasilPerbandingan = tanggalAwal.compareTo( tanggalAkhir );

        if ( hasilPerbandingan <= 0 ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "OK",
                        service.getOrderByTgl(request),
                        " Data Seluruh Penjualan dan Pesanan "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.OK );


        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request,
                        " Tanggal tidak valid "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }


    /*
     *
     * @Untuk Menampilkan Data Sales
     *
     */
    @PostMapping(
            value = "/getDataSales",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getDataSales( @RequestBody RequestTanggal request,
                                                      @RequestHeader(required = false) String token
    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        request,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }


        Date tanggalAwal = request.getTgl();

        Date tanggalAkhir = request.getTglAkhir();

        Integer hasilPerbandingan = tanggalAwal.compareTo( tanggalAkhir );

        if ( hasilPerbandingan <= 0 ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "200",
                        service.getDataSales( request ),
                        " Data Sales/Transaksi dan Keuntungan"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request ,
                        " Tanggal tidak valid "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }


    /*
     *
     * @Untuk Menampilkan Transaksi Yang Sudah Upload Bukti Pembayaran
     *
     */
    @GetMapping("/getStatusTransaksi")
    public ResponseEntity<BaseResponse> getStatusTransaksi( @RequestHeader(required = false) String token ){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        null,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }


        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.OK,
                "200",
                service.getStatusBayar(),
                " Data Status Pembayaran "
        );

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

    }


    /*
     *
     * @Untuk Konfirmasi Pembayaran Sudah Diterima Oleh Admin
     *
     */
    @PostMapping(
            value = "/setStatusTransaksi",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> setStatusTransaksi( @RequestBody RequestIdPenjualan request,
                                                            @RequestHeader(required = false) String token
    ){

//        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        request,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        if ( service.setStatusTransaksi( request ) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "200",
                        request,
                        " Status pembayaran berhasil dirubah "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request ,
                        " Transaksi tidak ditemukan "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }


    /*
     *
     * @Untuk Customer Melihat Status Pesanannya By IdPenjualan
     *
     */
    @PostMapping(
            value = "/getTracking",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getTracking( @RequestBody RequestIdPenjualan request ){


            BaseResponse baseResponse = service.getTracking( request.getIdPenjualan() );

            return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Admin Melihat Pengajuan Refund
     *
     */
    @GetMapping(
            value = "/getRefundStatus"
    )
    public ResponseEntity<BaseResponse> getRefundStatus( @RequestHeader(required = false) String token ){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        null,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.OK,
                "200",
                service.getRefundStatus(),
                " Status pembayaran berhasil dirubah "
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Admin Konfirmasi Refund Status di Setujui atau Tidak
     *
     */
    @PostMapping(
            value = "/setRefundStatus",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> setRefundStatus( @RequestBody RequestRefundStatus request,
                                                         @RequestHeader(required = false) String token
    ){

        // cek token
        if ( autentikasi.Autentication( token ) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        null,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.OK,
                "200",
                service.setRefundStatus(
                        request.getIdPenjualan(),
                        request.getStatusRefundDisetujui()
                ),
                " Status pembayaran berhasil dirubah "
        );

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }


    /*
     *
     * @Untuk Melihat Customer Yang Refund Status Disetujui juga Customer Yang Sudah Mengirim No Rekeningnya
     *
     */
    @GetMapping("/getRefund")
    public ResponseEntity<BaseResponse> getRefund(@RequestHeader(required = false) String token){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        null,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.OK,
                "200",
                service.getRefund(),
                " Status pembayaran berhasil dirubah "
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Konfirmasi Bahwa Uang Refund Sudah Dikirim ke No Rekening Customer
     *
     */
    @PostMapping(
            value = "/setRefund",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> setRefund( @RequestBody RequestSetRefund request,
                                                   @RequestHeader(required = false) String token
    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        null,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.OK,
                "200",
                service.setRefund( request.getIdRefundStatus() ),
                " Status pembayaran berhasil dirubah "
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }

}