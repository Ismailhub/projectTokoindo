package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestProduct;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ServiceProduct service;

    @PostMapping(
            value = "addProduct",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addProduct( @RequestBody RequestProduct request ){

        if ( request.getQtyMinStock() > 0
                && request.getQtyStock() > -1
                && request.getHargaBeli() > 0
                && request.getHargaJual() > 0
        ){

            if( service.create( request ) ){

                BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",request,"Berhasil Tambah Produck" );

                return new ResponseEntity<>( baseResponse,HttpStatus.OK );

            }else {

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal",request,"Gagal Tambah Produck" );

                return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

            }

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal",request,"Gagal Tambah Produck" );

            return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

        }

    }


    @PostMapping(
            value = "/editProduct",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> editProduct( @RequestBody RequestProduct request ){

        if ( request.getQtyMinStock() > 0
                && request.getHargaBeli() > 0
                && request.getHargaJual() > 0
        ){

            if( service.edit( request ) ){

                BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",request,"Berhasil edit product" );

                return new ResponseEntity<>( baseResponse,HttpStatus.OK );

            }else {

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal",request,"id product tidak ditemukan" );

                return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );
            }

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal",request,"Gagal edit product" );

            return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

        }

    }


    @GetMapping("/getProducts")
    public ResponseEntity<BaseResponse> getProducts(@RequestParam(defaultValue = "0")Integer page,
                                                    @RequestParam(defaultValue = "100")Integer limit
                                                    ){

        BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",service.getProducts(page,limit),"List Product" );

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }

}