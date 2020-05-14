package co.g2academy.indoapril_1.service;

import java.security.NoSuchAlgorithmException;

public interface ServiceMD5 {

    boolean checkPassword( String password, String hash ) throws NoSuchAlgorithmException;

    String hashPassword( String password ) throws NoSuchAlgorithmException;

}
