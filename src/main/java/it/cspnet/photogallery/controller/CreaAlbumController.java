/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.photogallery.controller;

import it.cspnet.photogallery.model.Album;
import it.cspnet.photogallery.model.JsonResults;
import it.cspnet.photogallery.model.Utente;
import it.cspnet.photogallery.servizi.Servizi;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author corsojava
 */
@Controller
public class CreaAlbumController {
    
    @Autowired
    private Servizi servizi;

    public void setServizi(Servizi servizi) {
        this.servizi = servizi;
    }
    
//    @RequestMapping(value = "/creaAlbum")
//    public @ResponseBody
//    JsonResults creaAlbum(@RequestBody Album album) {
//        File dir = new File("");
//    }
}
