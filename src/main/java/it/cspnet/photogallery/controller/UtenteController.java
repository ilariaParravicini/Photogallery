package it.cspnet.photogallery.controller;

import it.cspnet.photogallery.exception.ConfermatoException;
import it.cspnet.photogallery.exception.ExistingUserException;
import it.cspnet.photogallery.exception.UserNotFoundException;
import it.cspnet.photogallery.exception.WrongPasswordException;
import it.cspnet.photogallery.model.JsonResults;
import it.cspnet.photogallery.model.Utente;
import it.cspnet.photogallery.servizi.Servizi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UtenteController {
    
    @Autowired
    private Servizi servizi;

    public void setServizi(Servizi servizi) {
        this.servizi = servizi;
    }
    
     @RequestMapping(value = "/accedi", method = RequestMethod.POST)
    public @ResponseBody
    JsonResults login(@RequestBody Utente utente) {
//        logger.debug("sono nel metodo accedi di AuthController");
        JsonResults js = new JsonResults();
        try {
            js.setCodice(0);
            js.setRisultato(servizi.login(utente.getUsername(), utente.getPassword()));
//            logger.debug("Login effettuato correttamente");
        } catch (UserNotFoundException ex) {
//            logger.error("Eccezione: " + ex + "-" + ex.getMessage());
            js.setCodice(1);
            js.setMessaggio("Utente '" + utente.getUsername() + "' non trovato!");
        } catch (WrongPasswordException ex) {
//            logger.error("Eccezione: " + ex + "-" + ex.getMessage());
            js.setCodice(1);
            js.setMessaggio("Nome utente o password errata!");
        } catch (ConfermatoException ex) {
//            logger.error("Eccezione: " + ex + "-" + ex.getMessage());
            js.setCodice(1);
            js.setMessaggio("Non hai confermato la registrazione!");
        } catch (Exception ex) {
//            logger.error("Eccezione: " + ex + "-" + ex.getMessage());
            js.setCodice(1);
            js.setMessaggio("Sito in manutenzione: riprovare pi� tardi");
            System.out.println(ex);
        }
        return js;
    }
    
    @RequestMapping(value = "/registrati")
    public @ResponseBody JsonResults registrazioneUtente(@RequestBody Utente utente) {
//        logger.debug("Sono nel metodo di registrazione utente");
        JsonResults jR = new JsonResults();
        try {
            jR.setCodice(0);
            jR.setRisultato(servizi.creaUtente(utente));
//            logger.debug("Utente registrato correttamente");
        } catch (ExistingUserException ex) {
            jR.setCodice(1);
            jR.setMessaggio("Utente già esistente");
//            logger.error("Eccezione: "+ex+"-"+ex.getMessage());
        } catch (Exception ex) {
            jR.setCodice(1);
            jR.setMessaggio("Sito in manutenzione: riprovare più tardi");
//            logger.error("Eccezione: "+ex+"-"+ex.getMessage());
            System.out.println(ex);
        }        
        return jR;
    }

}
