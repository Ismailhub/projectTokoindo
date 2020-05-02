package co.g2academy.indoapril_1.controller;

import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService service;

    //POST LOGIN
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> postLogin( @RequestBody LoginRequest request ) throws NoSuchAlgorithmException {

        if ( request.getUsername() != null && request.getPassword() != null || request.getUsername() == "" && request.getPassword() == "" ){

            BaseResponse baseResponse = service.loginByUsername( request );

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }else {

            BaseResponse baseResponse = new BaseResponse(
                    HttpStatus.BAD_REQUEST,
                    "FAILED",
                    null,
                    "Username & Password Tidak Boleh Null"
            );

            return new ResponseEntity<>( baseResponse, baseResponse.getCode() );

        }

    }
}
