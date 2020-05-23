package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestSupplier;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
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

    @Autowired
    ServiceAdmin autentikasi;


    /*
     *
     * @Untuk Menampilkan Semua Supplier
     *
     */
    @GetMapping("/getSuppliers")
    public ResponseEntity<BaseResponse> getSuppliers( @RequestParam(defaultValue = "0")Integer page,
                                                      @RequestParam(defaultValue = "100")Integer limit,
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
                "OK",
                service.getSupplierList( page, limit ),
                "All Supplier"
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Menampilkan Supplier dan Productnya
     *
     */
    @GetMapping("/getSuppliersAndProduct")
    public ResponseEntity<BaseResponse> getSuppliersAndProduct( @RequestHeader(required = false) String token){

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
                service.getSupplierAndProductList(),
                "All Supplier & Produknya"
        );

        return new ResponseEntity<>( baseResponse, HttpStatus.OK );

    }


    /*
     *
     * @Untuk Menambah Supplier Baru
     *
     */
    @PostMapping(
            value = "/addSupplier",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addSupplier( @RequestBody RequestSupplier request,
                                                     @RequestHeader(required = false) String token
    ){

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

        if (
                request.getIdSupplier() != null
                || request.getNamaSupplier() == null
                && request.getAlamatSupplier() == null
                && request.getTelepon() == null
                && request.getNamaSupplier() == ""
                && request.getAlamatSupplier() == ""
                && request.getTelepon() == ""
        ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request ,
                        " data tidak valid "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

        if( service.create( request ) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "OK",
                        request,
                        "Sukses add supplier"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request,
                        "data sudah ada"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }


    /*
     *
     * @Untuk Merubah Data Supplier
     *
     */
    @PostMapping(
            value = "/editSupplier",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> editSupplier( @RequestBody RequestSupplier request,
                                                      @RequestHeader(required = false) String token
    ){

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

        if (
                request.getIdSupplier() == null
                && request.getNamaSupplier() == null
                && request.getAlamatSupplier() == null
                && request.getTelepon() == null
                && request.getNamaSupplier() == ""
                && request.getAlamatSupplier() == ""
                && request.getTelepon() == ""
        ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request ,
                        " data tidak valid "
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

        if ( service.edit( request ) ){

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.OK,
                        "OK",
                        request,
                        "Sukses edit supplier"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.OK );

        }else {

                BaseResponse baseResponse = new BaseResponse(
                        HttpStatus.BAD_REQUEST,
                        "Gagal",
                        request ,
                        "id supplier tidak ada"
                );

                return new ResponseEntity<>( baseResponse, HttpStatus.BAD_REQUEST );

        }

    }

}