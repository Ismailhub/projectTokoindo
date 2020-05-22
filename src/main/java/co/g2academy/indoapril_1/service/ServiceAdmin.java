package co.g2academy.indoapril_1.service;

import co.g2academy.indoapril_1.request.RequestAdmin;
import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;

import java.security.NoSuchAlgorithmException;

public interface ServiceAdmin {

    //login
    BaseResponse loginByEmail( LoginRequest request ) throws NoSuchAlgorithmException;

    boolean creat( RequestAdmin request ) throws NoSuchAlgorithmException;

    boolean edit( RequestAdmin request ) throws NoSuchAlgorithmException;

    boolean Autentication(String token);
}
