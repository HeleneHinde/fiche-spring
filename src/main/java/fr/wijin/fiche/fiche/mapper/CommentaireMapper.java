package fr.wijin.fiche.fiche.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.wijin.fiche.fiche.dto.CommentaireDto;
import fr.wijin.fiche.fiche.model.Commentaire;

@Component
public class CommentaireMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FicheMapper ficheMapper;

    public CommentaireDto mapCommentaireToCommentaireDto(Commentaire commentaire) {
        CommentaireDto commentaireDto = new CommentaireDto();
        commentaireDto.setId(commentaire.getId());
        commentaireDto.setAuteurCommentaire(userMapper.mapUserToUserDto(commentaire.getAuteurCommentaire()));
        commentaireDto.setDate(commentaire.getDate());
        commentaireDto.setTexteCommentaire(commentaire.getTexteCommentaire());
        commentaireDto.setFiche(ficheMapper.mapFicheToFicheDto(commentaire.getFiche()));
        return commentaireDto;
    }

    public Commentaire mapCommentaireDtoToCommentaire(CommentaireDto commentaireDto) {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(commentaireDto.getId());
        commentaire.setAuteurCommentaire(userMapper.mapUserDtoToUser(commentaireDto.getAuteurCommentaire()));
        commentaire.setDate(commentaireDto.getDate());
        commentaire.setTexteCommentaire(commentaireDto.getTexteCommentaire());
        commentaire.setFiche(ficheMapper.mapFicheDtoToFiche(commentaireDto.getFiche()));
        return commentaire;
    }
}
