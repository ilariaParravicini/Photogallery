package it.cspnet.photogallery.servizi;

import it.cspnet.photogallery.data.AlbumDao;
import it.cspnet.photogallery.data.UtenteDao;
import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.ExistingUserException;
import it.cspnet.photogallery.exception.FileGiaEsistenteException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.Album;
import it.cspnet.photogallery.model.Utente;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servizi")
@Transactional
public class ServiziImpl implements Servizi {
    
    @Autowired
    private UtenteDao utenteDao;
    @Autowired
    private AlbumDao albumDao;

    public void setUtenteDao(UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }
       
    @Override
    public Utente login(String username, String password) throws UserNotFoundException, WrongPasswordException, ConfermatoException {
        Utente user = utenteDao.findOne(username);
        if (user != null) {
            if (user.getConfermato().equals("si")) {
                if (password.equals(user.getPassword())) {
                    return user;
                } else {
                    throw new WrongPasswordException();
                }
            } else {
                throw new ConfermatoException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public Utente creaUtente(Utente utente) throws ExistingUserException, Exception {
         if (utenteDao.exists(utente.getUsername()))
            throw new ExistingUserException();
        else{
             File cartellaUtente = new File("C:/Fotografie/"+utente.getUsername());
             if(!cartellaUtente.exists()){
                 cartellaUtente.mkdir();
             }
            return utenteDao.save(utente);
        }
    }

    @Override
    public void creaAlbum(Album album) throws FileGiaEsistenteException {
        if (albumDao.exists(album.getNome())){
            throw new FileGiaEsistenteException();
        }else{
            albumDao.save(album);
            File dir = new File("C:/Fotografie/onda/"+album.getNome());
            dir.mkdir();
        }
    }

}
