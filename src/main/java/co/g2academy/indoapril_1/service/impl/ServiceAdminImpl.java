package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.model.ModelAdmin;
import co.g2academy.indoapril_1.repository.RepositoryAdmin;
import co.g2academy.indoapril_1.request.RequestAdmin;
import co.g2academy.indoapril_1.request.loginrequest.LoginRequest;
import co.g2academy.indoapril_1.response.loginresponse.BaseResponse;
import co.g2academy.indoapril_1.response.loginresponse.ResponseAdmin;
import co.g2academy.indoapril_1.service.ServiceAdmin;
import co.g2academy.indoapril_1.service.ServiceMD5;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Repository("ServiceAdmin")

public class ServiceAdminImpl implements ServiceAdmin {

    @Autowired
    private RepositoryAdmin repository;

    @Autowired
    private ServiceMD5 serviceMD5;

    //Login by user name and password
    @Override
    @Transactional
    public BaseResponse loginByEmail(LoginRequest request) throws NoSuchAlgorithmException {

        ModelAdmin entity = repository.getOneByEmail( request.getEmail() );

        String status = entity.getStatus();

        if ( status.equals("nonaktif") ){

            return new  BaseResponse(HttpStatus.FORBIDDEN, "FAILED", request, "akun nonaktif!");

        }

        if ( entity == null ) {

            return new  BaseResponse(HttpStatus.FORBIDDEN, "FAILED", null, "USERNAME SALAH!");

        }

        if( serviceMD5.checkPassword(request.getPassword(),entity.getPassword()) ){

            UUID uuid = UUID.randomUUID();

            //masukan token ke ModelAdmin
            entity.setToken(String.valueOf(uuid));

            ModelAdmin savedEntyty = repository.save(entity);

            return new BaseResponse(HttpStatus.OK, "Succes", toLoginResponseSimple(savedEntyty), "Succes");

        } else{

            return new BaseResponse(HttpStatus.FORBIDDEN, "FAILED", null, "PASSWORD SALAH!");

        }

    }

    private ResponseAdmin toLoginResponseSimple( ModelAdmin entity ) {

        return new ResponseAdmin(
                entity.getIdAdmin(),
                entity.getNamaAdmin(),
                entity.getEmail(),
                entity.getTelephon(),
                entity.getStatus(),
                entity.getToken());
    }

    @Override
    @Transactional
    public boolean creat( RequestAdmin request ) throws NoSuchAlgorithmException {

        if ( !repository.existsByEmail(request.getEmail()) ){

            String hashPassword = serviceMD5.hashPassword( request.getPassword() );

            request.setPassword( hashPassword );

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;

        }

    }

    private ModelAdmin toEntity( RequestAdmin request ){

        return ModelAdmin.builder()
                .idAdmin( request.getIdAdmin() )
                .namaAdmin( request.getNamaAdmin() )
                .email( request.getEmail() )
                .password( request.getPassword() )
                .telephon( request.getTelephon() )
                .status( request.getStatus() )
                .token( request.getToken() )
                .build();
    }


    @Override
    @Transactional
    public boolean edit( RequestAdmin request ) throws NoSuchAlgorithmException {

        if ( repository.existsById( request.getIdAdmin()) ){

            String hashPassword = serviceMD5.hashPassword( request.getPassword() );

            request.setPassword( hashPassword );

            repository.save( toEntity(request) );

            return true;

        }else {

            return false;

        }

    }
}