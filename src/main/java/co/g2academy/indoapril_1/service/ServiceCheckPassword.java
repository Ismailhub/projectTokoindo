package co.g2academy.indoapril_1.service;

import java.security.NoSuchAlgorithmException;

public interface ServiceCheckPassword {

    boolean checkPassword( String password, String hash ) throws NoSuchAlgorithmException;

}
