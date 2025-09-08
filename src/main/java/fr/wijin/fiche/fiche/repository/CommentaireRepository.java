package fr.wijin.fiche.fiche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wijin.fiche.fiche.model.Fiche;

public interface CommentaireRepository extends JpaRepository<Fiche, Integer> {
    
}
