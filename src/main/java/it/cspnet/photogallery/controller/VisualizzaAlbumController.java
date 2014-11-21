package it.cspnet.photogallery.controller;

import it.cspnet.photogallery.model.JsonResults;
import it.cspnet.photogallery.servizi.Servizi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VisualizzaAlbumController {
    
    @Autowired
    private Servizi servizi;

    public void setServizi(Servizi servizi) {
        this.servizi = servizi;
    }
    
    @RequestMapping(value = "/listaAlbum")
    public @ResponseBody
    JsonResults listaAlbum(){
        JsonResults jR = new JsonResults();
        try{
            jR.setCodice(0);
            jR.setRisultato(servizi.listaAlbum());
        } catch (Exception e) {
            jR.setCodice(1);
            jR.setMessaggio("MSG");
        }
        return jR;
    }
}
