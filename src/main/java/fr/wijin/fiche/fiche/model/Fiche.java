package fr.wijin.fiche.fiche.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fiches")
public class Fiche implements Serializable {

    private static final long serialVersionUID = -4561516486454L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String texteFiche;

    @Column
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User auteurFiche;

    @OneToMany(mappedBy = "commentaires", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "fiche_categorie", joinColumns = { @JoinColumn(name = "fiche_id") }, inverseJoinColumns = {
            @JoinColumn(name = "cetegorie_id") })
    private List<Categorie> categories;

    public Fiche() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexteFiche() {
        return texteFiche;
    }

    public void setTexteFiche(String texteFiche) {
        this.texteFiche = texteFiche;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getAuteurFiche() {
        return auteurFiche;
    }

    public void setAuteurFiche(User auteurFiche) {
        this.auteurFiche = auteurFiche;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
