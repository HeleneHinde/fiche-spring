package fr.wijin.fiche.fiche.form;

import java.time.LocalDateTime;
import java.util.Date;

import fr.wijin.fiche.fiche.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentaireForm {
    
        @NotNull
        @Size(min = 2, max = 250)
        private String texteCommentaire;

        @NotNull
        private User auteurCommentaire;

        @NotNull
        private LocalDateTime date;

        public CommentaireForm() {
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

        public void setDate() {
            this.date = LocalDateTime.now();
        }
}
