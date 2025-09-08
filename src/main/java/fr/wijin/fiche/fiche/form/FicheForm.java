package fr.wijin.fiche.fiche.form;

import java.util.List;

import fr.wijin.fiche.fiche.dto.CategorieDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FicheForm {

    @NotNull
    @Size(min = 2, max = 250)
    private String texteFiche;

    @NotNull
    private List<CategorieDto> categorieDtos;

    public FicheForm() {
    }

    public String getTexteFiche() {
        return texteFiche;
    }

    public void setTexteFiche(String texteFiche) {
        this.texteFiche = texteFiche;
    }

    public List<CategorieDto> getCategorieDtos() {
        return categorieDtos;
    }

    public void setCategorieDtos(List<CategorieDto> categorieDtos) {
        this.categorieDtos = categorieDtos;
    }
}
