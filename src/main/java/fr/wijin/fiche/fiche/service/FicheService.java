package fr.wijin.fiche.fiche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wijin.fiche.fiche.dto.FicheDto;
import fr.wijin.fiche.fiche.mapper.FicheMapper;
import fr.wijin.fiche.fiche.model.Fiche;
import fr.wijin.fiche.fiche.repository.FicheRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class FicheService {
    
    @Autowired
	private FicheRepository ficheRepository;
	
	@Autowired
	private FicheMapper ficheMapper;
	
	public List<FicheDto> findAll() {
		return ficheRepository
				.findAll()
				.stream()
				.map(ficheMapper::mapFicheToFicheDto)
				.toList();
	}

	public Optional<FicheDto> findById(Integer id) {
		Fiche fiche = ficheRepository.findById(id)
					.orElse(null);
		if (fiche == null) {
			return Optional.ofNullable( (FicheDto) null);
		}
		return Optional.of(
				ficheMapper.mapFicheToFicheDto(fiche));
	}

	public void delete(FicheDto fiche) {
		this.ficheRepository.deleteById(fiche.getId().intValue());
	}

	public FicheDto save(FicheDto fiche) {
		return ficheMapper.mapFicheToFicheDto(this.ficheRepository.save(
				ficheMapper.mapFicheDtoToFiche(fiche)));
	}
}
