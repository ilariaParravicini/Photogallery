package it.cspnet.photogallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTENTI")
public class Utente implements Serializable {

    @Id
    @Column(name = "USERNAME", length = 20)
    private String username;
    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;
    @Column(name = "PROFILO", length = 20, nullable = false, columnDefinition = "varchar(20) DEFAULT 'user'")
    private String profilo = "user";
    @Column(name="CONFERMATO",length = 5,nullable = false,columnDefinition = "varchar(20) DEFAULT 'NO'")
    private String confermato = "si";
    @Column(name="EMAIL",length = 50,nullable = false)
    private String email;
    
    @OneToMany(mappedBy="utente")
    @JsonIgnore
    private Set<Album> albums = new HashSet<Album>();
    
        public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilo() {
        return profilo;
    }

    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }

    public String getConfermato() {
        return confermato;
    }

    public void setConfermato(String confermato) {
        this.confermato = confermato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        return true;
    }

}
