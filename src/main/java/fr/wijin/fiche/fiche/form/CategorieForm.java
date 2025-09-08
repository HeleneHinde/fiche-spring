package fr.wijin.fiche.fiche.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategorieForm {

    @NotNull
    @Size(min = 2, max = 250)
    private String nom;
    
    public CategorieForm() {
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
