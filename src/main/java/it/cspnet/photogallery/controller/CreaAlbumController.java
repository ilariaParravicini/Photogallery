package it.cspnet.photogallery.controller;

import it.cspnet.photogallery.exception.FileGiaEsistenteException;
import it.cspnet.photogallery.model.Album;
import it.cspnet.photogallery.model.JsonResults;
import it.cspnet.photogallery.model.Utente;
import it.cspnet.photogallery.servizi.Servizi;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreaAlbumController {
    
    @Autowired
    private Servizi servizi;

    public void setServizi(Servizi servizi) {
        this.servizi = servizi;
    }
    
    @RequestMapping(value = "/creaAlbum")
    public @ResponseBody
    JsonResults creaAlbum(@RequestBody Album album, HttpServletRequest req) {
        //prendere utente in sessione
        JsonResults jR = new JsonResults();
        String username = req.getParameter("username");
        try{
            jR.setCodice(0);
            servizi.creaAlbum(album, username);
            jR.setMessaggio("ok");
        } catch (FileGiaEsistenteException ex){
            jR.setCodice(1);
            jR.setMessaggio("File già esistente. Specificare un altro nome");            
        }
        return jR;
    }
}
