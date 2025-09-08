package fr.wijin.fiche.fiche.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import fr.wijin.fiche.fiche.model.User;

public class CommentaireDto implements Serializable {
   
        private static final long serialVersionUID = -6478965866248L;

        private Long id;

        private String texteCommentaire;

        private User auteurCommentaire;

        private LocalDateTime date;

        public CommentaireDto() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTexteCommentaire() {
            return texteCommentaire;
        }

        public void setTexteCommentaire(String texte) {
            this.texteCommentaire = texte;
        }

        public User getAuteurCommentaire() {
            return auteurCommentaire;
        }

        public void setAuteurCommentaire(User auteurCommentaire) {
            this.auteurCommentaire = auteurCommentaire;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }


    
}
