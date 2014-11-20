package it.cspnet.photogallery.data;

import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.JsonResults;
import it.cspnet.photogallery.model.Utente;
import it.cspnet.photogallery.servizi.ServiziImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository("utenteDao")
public interface UtenteDao extends JpaRepository<Utente, String>{
    
}


