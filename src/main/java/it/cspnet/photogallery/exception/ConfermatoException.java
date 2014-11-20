package it.cspnet.photogallery.exception;

public class ConfermatoException extends Exception {

    public ConfermatoException() {
    }

    public ConfermatoException(String message) {
        super(message);
    }

    public ConfermatoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfermatoException(Throwable cause) {
        super(cause);
    }

    public ConfermatoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
