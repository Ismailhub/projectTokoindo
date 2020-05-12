package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestPenjualan;
import co.g2academy.indoapril_1.request.RequestPenjualanTgl;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceProductMasuk;
import co.g2academy.indoapril_1.service.ServicePenjualan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("penjualan")
public class PenjualanController {

    @Autowired
    ServicePenjualan service;

    @Autowired
    ServiceProductMasuk serviceProductMasuk;


    @PostMapping(
            value = "/addPenjualan",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addPenjualan( @RequestBody List<RequestPenjualan> request ){

        boolean validBarnag = true;

        boolean validQty = true;

        for( int i = 0; i < request.size(); i++ ){

            validBarnag = validBarnag && serviceProductMasuk.findIdProduct( request.get(i).getId_Barang() );

            validQty = validQty && request.get(i).getQty_Detail() > 0;

        }

        if ( validBarnag && validQty ){

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "Suksess", service.create(request), "Order Berhasil");

            return new ResponseEntity<>( baseResponse, HttpStatus.CREATED );

        }else {

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "Failed", request, "Qty Minimal 1 & ID Barang Harus Sudah Terdaftar");

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

    //lihat order by tgl
    @PostMapping(
            value = "/getPenjualan",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> getPenjualan( @RequestBody RequestPenjualanTgl request ){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getOrderByTgl(request), "Order pada tanggal "+request.getTgl());

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

}