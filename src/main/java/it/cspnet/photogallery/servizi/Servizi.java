package it.cspnet.photogallery.servizi;

import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.ExistingUserException;
import it.cspnet.photogallery.exception.FileGiaEsistenteException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.Album;
import it.cspnet.photogallery.model.Utente;
import java.util.Collection;

public interface Servizi {
    
    public Utente login(String username, String password) throws UserNotFoundException, WrongPasswordException, ConfermatoException;
    
    public Utente creaUtente(Utente utente) throws ExistingUserException,Exception;

    public void creaAlbum(Album album, String username) throws FileGiaEsistenteException;

    public Collection<Album> listaAlbum();
    
}
