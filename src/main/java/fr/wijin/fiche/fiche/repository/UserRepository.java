package fr.wijin.fiche.fiche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wijin.fiche.fiche.model.Fiche;

public interface UserRepository extends JpaRepository<Fiche, Integer> {
    
}
