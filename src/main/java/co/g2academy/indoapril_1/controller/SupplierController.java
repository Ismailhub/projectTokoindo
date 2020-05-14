package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    ServiceSupplier service;

    // untuk menampilkan semua supplier
    @GetMapping("/getSuppliers")
    public ResponseEntity<BaseResponse> getSuppliers(@RequestParam(defaultValue = "0")Integer page,
                                                     @RequestParam(defaultValue = "100")Integer limit){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getSupplierList(page, limit), "All Supplier");

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }

    @GetMapping("/getSuppliersAndProduct")
    public ResponseEntity<BaseResponse> getSuppliersAndProduct(){

        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", service.getSupplierAndBarangList(), "All Supplier & Produknya");

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

    @PostMapping(
            value = "/addSupplier",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addSupplier( @RequestBody RequestSupplier request ){

        if( service.create(request) ){

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", request, "Sukses add supplier");

            return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

            BaseResponse baseResponse = new BaseResponse(HttpStatus.BAD_REQUEST, "Gagal", request, "data sudah ada");

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );
        }

    }

    @PostMapping(
            value = "/editSupplier",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> editSupplier( @RequestBody RequestSupplier request){

        if ( service.edit(request) ){

            BaseResponse baseResponse = new BaseResponse(HttpStatus.OK, "OK", request , "Sukses edit supplier");

            return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

            BaseResponse baseResponse = new BaseResponse(HttpStatus.BAD_REQUEST, "Gagal", request , "id supplier tidak ada");

            return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );
        }

    }

}