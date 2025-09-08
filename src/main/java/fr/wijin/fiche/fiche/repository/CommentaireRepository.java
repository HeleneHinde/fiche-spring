package fr.wijin.fiche.fiche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wijin.fiche.fiche.model.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    
}
