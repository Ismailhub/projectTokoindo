package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestProduct;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
import co.g2academy.indoapril_1.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@Configuration
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ServiceProduct service;

    @Autowired
    ServiceAdmin autentikasi;

    @RequestMapping(
            value = "/uploadGambar/{idProduct}",
            method = RequestMethod.POST,
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<BaseResponse> uploadGambar(@PathVariable Integer idProduct,
                                                     @RequestParam(value = "file") MultipartFile file,
                                                     @RequestHeader String token
                                                     ){

        // cek token
        if ( autentikasi.Autentication(token) ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.FORBIDDEN, "Ditolak", null, "Harus Login");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        System.out.println(file.getOriginalFilename());

        System.out.println(file.getContentType());

        if ( !file.isEmpty() ){
            try {

                if ( service.productIsExsistById(idProduct) ){

                    BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",service.saveGambar(idProduct, file),"berhasil upload gambar product" );

                    return new ResponseEntity<>( baseResponse,HttpStatus.OK );

                }else {

                    BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal",null,"Product tidak ditemukan" );

                    return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

                }

            }catch (Exception e){

                System.out.println(e);

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal Upload",null,"Gagal upload gambar Produck" );

                return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

            }

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST,"Gagal Upload","Gagal","File Kosong" );

            return new ResponseEntity<>( baseResponse,HttpStatus.BAD_REQUEST );

        }
    }

    @PostMapping(
            value = "/addProduct",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addProduct( @RequestBody RequestProduct request,
                                                    @RequestHeader String token
    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.FORBIDDEN, "Ditolak", request, "Harus Login");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        if ( request.getQtyMinStock() > 0
                && request.getQtyStock() == 0
                && request.getHargaBeli() > 0
                && request.getHargaJual() > 0
                && request.getNamaProduct() != null
                && request.getMerek() != null
                && request.getKategori() != null
                && request.getUkuran() != null
                && request.getRasa() != null
                && request.getIsiPerkarton() != null
                && request.getDeskripsi() != null
                && request.getIdSupplier() != null
                && request.getNamaProduct() != ""
                && request.getMerek() != ""
                && request.getKategori() != ""
                && request.getUkuran() != ""
                && request.getRasa() != ""
                && request.getIsiPerkarton() != ""
                && request.getDeskripsi() != ""
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
    public ResponseEntity<BaseResponse> editProduct( @RequestBody RequestProduct request,
                                                     @RequestHeader String token
    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.FORBIDDEN, "Ditolak", request, "Harus Login");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        if ( request.getQtyMinStock() > 0
                && request.getHargaBeli() > 0
                && request.getHargaJual() > 0
                && request.getNamaProduct() != null
                && request.getMerek() != null
                && request.getKategori() != null
                && request.getUkuran() != null
                && request.getRasa() != null
                && request.getIsiPerkarton() != null
                && request.getDeskripsi() != null
                && request.getIdSupplier() != null
                && request.getNamaProduct() != ""
                && request.getMerek() != ""
                && request.getKategori() != ""
                && request.getUkuran() != ""
                && request.getRasa() != ""
                && request.getIsiPerkarton() != ""
                && request.getDeskripsi() != ""
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
                                                    @RequestParam(defaultValue = "100")Integer limit,
                                                    @RequestHeader String token
                                                    ){

        // cek token
        if ( autentikasi.Autentication(token) ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.FORBIDDEN, "Ditolak", null, "Harus Login");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",service.getProducts(page,limit),"List Product" );

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }

    @GetMapping("/cekMinimumStock")
    public ResponseEntity<BaseResponse> cekMinimumStock(@RequestHeader String token){

        // cek token
        if ( autentikasi.Autentication(token) ){

            BaseResponse baseResponse = new BaseResponse( HttpStatus.FORBIDDEN, "Ditolak", null, "Harus Login");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

        BaseResponse baseResponse = new BaseResponse( HttpStatus.OK,"Ok",service.getCekMinStock(),"Cek Minimum Stock" );

        return new ResponseEntity<>( baseResponse,HttpStatus.OK );

    }

}