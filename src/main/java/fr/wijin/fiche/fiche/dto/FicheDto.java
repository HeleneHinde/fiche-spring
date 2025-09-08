package fr.wijin.fiche.fiche.dto;

import java.io.Serializable;
import java.util.Date;
import fr.wijin.fiche.fiche.model.User;

public class FicheDto implements Serializable{
    
        private static final long serialVersionUID = -4561516486L;

        private Long id;

        private String texteFiche;

        private Date date;

        private User auteurFiche;

        public FicheDto() {
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public User getAuteurFiche() {
            return auteurFiche;
        }

        public void setAuteurFiche(User auteurFiche) {
            this.auteurFiche = auteurFiche;
        }

        
}
