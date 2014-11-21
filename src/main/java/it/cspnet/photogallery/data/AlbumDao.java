package it.cspnet.photogallery.data;

import it.cspnet.photogallery.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("albumDao")
public interface AlbumDao extends JpaRepository<Album, String>{
    
}
