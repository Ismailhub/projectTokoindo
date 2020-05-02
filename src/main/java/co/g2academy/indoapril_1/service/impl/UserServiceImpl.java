package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.UserModel;
import co.g2academy.indoapril_1.repository.UserRepository;
import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.response.loginresponse.UserResponse;
import co.g2academy.indoapril_1.service.ServiceCheckPassword;
import co.g2academy.indoapril_1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Repository("UserService")

public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private ServiceCheckPassword verivication;

    //Login by user name and password
    @Override
    @Transactional
    public BaseResponse loginByUsername(LoginRequest request) throws NoSuchAlgorithmException {

        UserModel entity = repository.getOneByUsername( request.getUsername() );

        if ( entity==null ) {

            return new  BaseResponse(HttpStatus.FORBIDDEN, "FAILED", null, "USERNAME SALAH!");

        }

        if( verivication.checkPassword(request.getPassword(),entity.getPassword()) ){

            UUID uuid = UUID.randomUUID();

            //masukan token ke UserModel
            entity.setToken(String.valueOf(uuid));

            UserModel savedEntyty = repository.save(entity);

            return new BaseResponse(HttpStatus.OK, "Succes", toLoginResponseSimple(savedEntyty), "Succes");

        } else{

            return new BaseResponse(HttpStatus.FORBIDDEN, "FAILED", null, "PASSWORD SALAH!");

        }

    }

    private UserResponse toLoginResponseSimple(UserModel entity ) {

        return new UserResponse(
                entity.getId_User(),
                entity.getNama_User(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getAlamat_Penempatan(),
                entity.getTelephon_User(),
                entity.getStatus(),
                entity.getToken());
    }

}