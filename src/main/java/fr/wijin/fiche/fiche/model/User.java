package fr.wijin.fiche.fiche.model;

import java.io.Serializable;
import java.util.List;

import fr.wijin.fiche.fiche.model.enums.Grants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
    
    private static final long serialVersionUID = -5179286429559866248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String username;

    @Column(length = 255)
    private String password;

    @OneToMany(mappedBy = "commentaires", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "fiches", cascade = CascadeType.DETACH)
    private List<Fiche> fiches;

    @Enumerated(EnumType.STRING)
    @Column(name = "grants")
    private List<Grants> grants;

    public User() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public List<Commentaire> getCommentaires() {
        return commentaires;
    }
    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
    public List<Grants> getGrants() {
        return grants;
    }
    public void setGrants(List<Grants> grants) {
        this.grants = grants;
    }

    
    
}
