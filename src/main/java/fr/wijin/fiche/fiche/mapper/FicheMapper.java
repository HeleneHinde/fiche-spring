package fr.wijin.fiche.fiche.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.wijin.fiche.fiche.dto.FicheDto;
import fr.wijin.fiche.fiche.model.Fiche;

@Component
public class FicheMapper {

    @Autowired
    private UserMapper userMapper;

    private CategorieMapper categorieMapper;

    public FicheDto mapFicheToFicheDto(Fiche fiche) {
        FicheDto ficheDto = new FicheDto();
        ficheDto.setAuteurFiche(userMapper.mapUserToUserDto(fiche.getAuteurFiche()));
        ficheDto.setDate(fiche.getDate());
        ficheDto.setId(fiche.getId());
        ficheDto.setTexteFiche(fiche.getTexteFiche());
        ficheDto.setCategories(fiche.getCategories().stream().map(categorieMapper::mapCategorieToCategorieDto).toList());
        return ficheDto;
    }

    public Fiche mapFicheDtoToFiche(FicheDto ficheDto) {
        Fiche fiche = new Fiche();
        fiche.setAuteurFiche(userMapper.mapUserDtoToUser(ficheDto.getAuteurFiche()));
        fiche.setDate(ficheDto.getDate());
        fiche.setId(ficheDto.getId());
        fiche.setTexteFiche(ficheDto.getTexteFiche());
        fiche.setCategories(ficheDto.getCategories().stream().map(categorieMapper::mapCategorieDtoToCategorie).toList());
        return fiche;
    }

}
