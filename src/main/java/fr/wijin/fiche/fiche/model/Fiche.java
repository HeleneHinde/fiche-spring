package fr.wijin.fiche.fiche.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fiches")
public class Fiche implements Serializable{
    
        private static final long serialVersionUID = -4561516486454L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 500)
        private String texteFiche;

        @Column
        private Date date;

        @ManyToOne(fetch = FetchType.LAZY)
        private User auteurFiche;

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
