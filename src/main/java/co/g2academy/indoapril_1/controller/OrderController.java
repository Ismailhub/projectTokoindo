package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestOrder;
import co.g2academy.indoapril_1.request.RequestOrderTgl;
import co.g2academy.indoapril_1.response.ResponseOrder;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import co.g2academy.indoapril_1.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api_1")
public class OrderController {

    @Autowired
    ServiceOrder service;

    @Autowired
    ServiceBarangMasuk serviceBarangMasuk;

    //Menambah Data Barang Masuk
    @PostMapping(value = "/InputOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> postBarangMasuk( @RequestBody List<RequestOrder> request ){

        boolean validBarnag = true;

        boolean validQty = true;

        for( int i = 0; i < request.size(); i++ ){

            validBarnag = validBarnag && serviceBarangMasuk.findIdBarang( request.get(i).getId_Barang() );

            validQty = validQty && request.get(i).getQty_Detail() > 0;

        }

        if ( validBarnag && validQty ){

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                    "Suksess",
                    service.create(request),
                    "Order Berhasil");

            return new ResponseEntity<>( baseResponse, HttpStatus.CREATED );

        }else {

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                    "Failed",
                    request,
                    "Qty Minimal 1 & ID Barang Harus Sudah Terdaftar");

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

    //lihat order by tgl
    @PostMapping( value = "/getOrderByTgl", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<BaseResponse> getOrder( @RequestBody RequestOrderTgl request ){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                "OK",
                service.getOrderByTgl(request),
                "Order pada tanggal "+request.getTgl());

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

}