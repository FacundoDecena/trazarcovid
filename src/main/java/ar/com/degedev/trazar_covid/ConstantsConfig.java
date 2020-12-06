package ar.com.degedev.trazar_covid;

public interface ConstantsConfig {

    // Spring security
    String HEADER_AUTHORIZACION_KEY = "Authorization";
    String TOKEN_BEARER_PREFIX = "Bearer";

    // JWT
    String ISSUER_INFO = "https://trazar.gob.ar/";
    String SIGNATURE_KEY = "milanesas4life";
    long TOKEN_EXPIRATION_TIME = 3600000; // 1 hora en ms

}
