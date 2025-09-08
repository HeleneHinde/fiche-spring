package fr.wijin.fiche.fiche.mapper;

import org.springframework.stereotype.Component;

import fr.wijin.fiche.fiche.dto.CategorieDto;
import fr.wijin.fiche.fiche.model.Categorie;

@Component
public class CategorieMapper {

    public CategorieDto mapCategorieToCategorieDto(Categorie categorie) {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setId(categorie.getId());
        categorieDto.setNom(categorie.getNom());

        return categorieDto;
    }

    public Categorie mapCategorieDtoToCategorie(CategorieDto categorieDto) {
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNom(categorieDto.getNom());

        return categorie;
    }
}
