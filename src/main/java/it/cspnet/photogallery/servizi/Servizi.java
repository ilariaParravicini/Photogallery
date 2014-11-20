package it.cspnet.photogallery.servizi;

import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.ExistingUserException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.Utente;

public interface Servizi {
    
    public Utente login(String username, String password) throws UserNotFoundException, WrongPasswordException, ConfermatoException;
    
    public Utente creaUtente(Utente utente) throws ExistingUserException,Exception;
    
}
