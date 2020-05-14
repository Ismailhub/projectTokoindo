package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.RequestAdmin;
import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ServiceAdmin service;

    //POST LOGIN
    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> postLogin( @RequestBody LoginRequest request ) throws NoSuchAlgorithmException {

        if ( request.getEmail() != null && request.getPassword() != null || request.getEmail() == "" && request.getPassword() == "" ){

            BaseResponse baseResponse = service.loginByEmail( request );

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "FAILED", request, "Username & Password Tidak Boleh Null");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

    }


    @PostMapping(
            value = "/addAdmin",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> addAdmin( @RequestBody RequestAdmin request ) throws NoSuchAlgorithmException {

        if ( request.getEmail() != null
                && request.getPassword() != null
                && request.getNamaAdmin() != null
                && request.getTelephon() != null
        ){

            if ( service.creat( request ) ){

                BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "Berhasil", request, "Tambah Admin Berhasil");

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

            }else {

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request, "Email sudah terdaftar");

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

            }

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request, "Data tidak lengkap");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

    }


    @PostMapping(
            value = "/editAdmin",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> editAdmin( @RequestBody RequestAdmin request ) throws NoSuchAlgorithmException {

        if ( request.getIdAdmin() != null
                && request.getEmail() != null
                && request.getPassword() != null
                && request.getNamaAdmin() != null
                && request.getTelephon() != null
        ){

            if ( service.edit( request ) ){

                BaseResponse baseResponse = new BaseResponse( HttpStatus.OK, "Berhasil", request, "Edit Admin Berhasil");

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

            }else {

                BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request, "Tidak ada user dengan id ="+request.getIdAdmin());

                return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

            }

        }else {

            BaseResponse baseResponse = new BaseResponse( HttpStatus.BAD_REQUEST, "Gagal", request, "Data tidak lengkap");

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

    }
}