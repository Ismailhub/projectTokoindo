package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.service.ServiceMD5;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
@Repository("ServiceMD5")
public class ServiceMD5Impl implements ServiceMD5 {

    @Override
    @Transactional
    public boolean checkPassword( String password, String hash ) throws NoSuchAlgorithmException {

        return hashText( password ).equals( hash );

    }

    @Override
    public String hashPassword( String password ) throws NoSuchAlgorithmException {

        return hashText(password);

    }

    private String hashText( String password ) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(password.getBytes());

        byte[] digest = md.digest();

        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return myHash;

    }
}
