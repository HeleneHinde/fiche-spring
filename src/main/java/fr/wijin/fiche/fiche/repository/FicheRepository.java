package fr.wijin.fiche.fiche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wijin.fiche.fiche.model.Fiche;

public interface FicheRepository extends JpaRepository<Fiche, Integer> {
    
}
