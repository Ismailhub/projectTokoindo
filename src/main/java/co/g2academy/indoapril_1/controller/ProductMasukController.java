package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestProductMasuk;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
import co.g2academy.indoapril_1.service.ServiceProductMasuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("product")
public class ProductMasukController {

    @Autowired
    ServiceProductMasuk service;

    @Autowired
    ServiceAdmin autentikasi;

    @GetMapping("/getProductMasuk")
    public ResponseEntity<BaseResponse> getProductMasuk( @RequestHeader(required = false) String token ){

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
                "OK",
                service.getProductMasukList(),
                "Sukses"
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Menambah Stock Product
     *
     */
    @PostMapping(
            value = "/addProductStock",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addProductStock( @RequestBody List<RequestProductMasuk> request,
                                                         @RequestHeader(required = false) String token
    ) {

        // cek token
        if ( autentikasi.Autentication( token ) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.FORBIDDEN,
                        "Ditolak",
                        request,
                        "Harus Login"
                );

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }


        boolean validNamaBarang = true;

        boolean validQty = true;

        for( int i = 0; i < request.size(); i++ ){

            validNamaBarang = validNamaBarang && service.findNamaProduct( request.get(i).getNamaProduct() );

            validQty = validQty && request.get(i).getQtyMasuk() > 0;

        }

        if ( validNamaBarang && validQty ){

                service.create( request );

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "OK",
                        null,
                        "Berhasil Menambah Stock Product"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.CREATED );

        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Failed",
                        request,
                        "Qtt Input Minimal 1 & ID Barang Harus Sudah Terdaftar"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

}
