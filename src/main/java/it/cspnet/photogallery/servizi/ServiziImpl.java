package it.cspnet.photogallery.servizi;

import it.cspnet.photogallery.data.UtenteDao;
import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiziImpl implements Servizi {
    
    @Autowired
    private UtenteDao utenteDao;

    public void setUtenteDao(UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
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

}
