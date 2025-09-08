package fr.wijin.fiche.fiche.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class FicheDto implements Serializable{
    
        private static final long serialVersionUID = -4561516486L;

        private Long id;

        private String texteFiche;

        private LocalDateTime date;

        private UserDto auteurFiche;

        private List<CategorieDto> categories;

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

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public UserDto getAuteurFiche() {
            return auteurFiche;
        }

        public void setAuteurFiche(UserDto auteurFiche) {
            this.auteurFiche = auteurFiche;
        }

        public List<CategorieDto> getCategories() {
            return categories;
        }

        public void setCategories(List<CategorieDto> categories) {
            this.categories = categories;
        }

        
}
