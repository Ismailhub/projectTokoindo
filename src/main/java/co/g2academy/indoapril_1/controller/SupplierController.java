package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplier;
import co.g2academy.indoapril_1.response.ResponseSupplierAndBarang;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    ServiceSupplier service;

    // untuk menampilkan semua supplier
    @GetMapping("/getSuppliers")
    public ResponseEntity<BaseResponse> getSuppliers(){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                "OK",
                service.getSupplierList(),
                "All Supplier");

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }

    @GetMapping("/getSuppliersAndBarang")
    public ResponseEntity<BaseResponse> getSuppliersAndBarang(){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                "OK",
                service.getSupplierAndBarangList(),
                "All Supplier & Produknya");

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

    @PostMapping(value = "/setSupplier", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> setSupplier( @RequestBody RequestSupplier request ){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK,
                "OK",
                service.create(request),
                "Sukses");

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }

}
