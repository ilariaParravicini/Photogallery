package it.cspnet.photogallery.exception;

public class FileGiaEsistenteException extends Exception{

    public FileGiaEsistenteException() {
    }

    public FileGiaEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileGiaEsistenteException(Throwable cause) {
        super(cause);
    }

    public FileGiaEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
