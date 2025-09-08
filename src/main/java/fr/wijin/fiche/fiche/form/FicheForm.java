package fr.wijin.fiche.fiche.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FicheForm {

    @NotNull
    @Size(min = 2, max = 250)
    private String texteFiche;

    public FicheForm() {
    }

    public String getTexteFiche() {
        return texteFiche;
    }

    public void setTexteFiche(String texteFiche) {
        this.texteFiche = texteFiche;
    }
}
