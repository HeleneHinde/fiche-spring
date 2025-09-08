package fr.wijin.fiche.fiche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wijin.fiche.fiche.dto.CategorieDto;
import fr.wijin.fiche.fiche.mapper.CategorieMapper;
import fr.wijin.fiche.fiche.model.Categorie;
import fr.wijin.fiche.fiche.repository.CategorieRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private CategorieMapper categorieMapper;

    public List<CategorieDto> findAll() {
        return categorieRepository
                .findAll()
                .stream()
                .map(categorieMapper::mapCategorieToCategorieDto)
                .toList();
    }

    public Optional<CategorieDto> findById(Integer id) {
        Categorie categorie = categorieRepository.findById(id)
                .orElse(null);
        if (categorie == null) {
            return Optional.ofNullable((CategorieDto) null);
        }
        return Optional.of(
                categorieMapper.mapCategorieToCategorieDto(categorie));
    }

    public void delete(CategorieDto categorie) {
        this.categorieRepository.deleteById(categorie.getId().intValue());
    }

    public CategorieDto save(CategorieDto categorie) {
        return categorieMapper.mapCategorieToCategorieDto(this.categorieRepository.save(
                categorieMapper.mapCategorieDtoToCategorie(categorie)));
    }
}
