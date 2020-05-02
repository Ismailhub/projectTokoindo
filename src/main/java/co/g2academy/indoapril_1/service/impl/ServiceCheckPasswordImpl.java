package co.g2academy.indoapril_1.service.impl;

import co.g2academy.indoapril_1.service.ServiceCheckPassword;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
@Repository("ServiceCheckPassword")

public class ServiceCheckPasswordImpl implements ServiceCheckPassword {

    @Override
    @Transactional
    public boolean checkPassword( String password, String hash ) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        System.out.println(hash);

        return myHash.equals( hash );
    }
}
