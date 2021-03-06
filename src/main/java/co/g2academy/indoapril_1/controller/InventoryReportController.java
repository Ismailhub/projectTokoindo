package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestTanggal;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
import co.g2academy.indoapril_1.service.ServiceInventoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("report")
public class InventoryReportController {

    @Autowired
    ServiceInventoryReport service;

    @Autowired
    ServiceAdmin autentikasi;


    /*
     *
     * @Untuk Laporan Inventory
     *
     */
    @PostMapping(
            value = "/getInventoryReport",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getInventoryReport( @RequestBody RequestTanggal request,
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

                BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getInventoryReportBy( request ), "Inventory Report");

                return new ResponseEntity<>( baseResponse,HttpStatus.OK );

        }else {

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request , " Tanggal tidak valid " );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

}