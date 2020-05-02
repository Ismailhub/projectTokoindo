package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.repository.RepositoryBarangMasuk;
import co.g2academy.indoapril_1.request.RequestBarangMasuk;
import co.g2academy.indoapril_1.response.ResponseBarangMasuk;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceBarangMasuk;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api_1")
public class BarangMasukController  {
    @Autowired
    ServiceBarangMasuk service;

    //Menampilkan Seluruh Data
    @GetMapping("/BarangMasuk")
    public ResponseEntity<BaseResponse> getBarangMasuk(){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getBarangMasukList(), "Sukses");

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }

    //Menambah Data Barang Masuk
    @PostMapping(value = "/TambahBarangMasuk", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> postBarangMasuk( @RequestBody RequestBarangMasuk request ) {

        if ( request.getQtt_Barang_Masuk() < 1 || service.findIdBarang( request.getId_Barang() ) != true ){

            BaseResponse baseResponse = new BaseResponse(HttpStatus.BAD_REQUEST, "Failed", request, "Qtt Input Minimal 1 & ID Barang Harus Sudah Terdaftar");

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);

        }else {

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.create( request ), "Sukses");

            return new ResponseEntity<>( baseResponse, HttpStatus.CREATED );

        }

    }

}
