package fr.wijin.fiche.fiche.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentaireForm {
    
        @NotNull
        @Size(min = 2, max = 250)
        private String texteCommentaire;

        public CommentaireForm() {
        }

        public String getTexteCommentaire() {
            return texteCommentaire;
        }

        public void setTexteCommentaire(String texte) {
            this.texteCommentaire = texte;
        }
}
