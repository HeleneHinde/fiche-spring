package fr.wijin.fiche.fiche.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fr.wijin.fiche.fiche.dto.CommentaireDto;
import fr.wijin.fiche.fiche.mapper.CommentaireMapper;
import fr.wijin.fiche.fiche.mapper.UserMapper;
import fr.wijin.fiche.fiche.model.Commentaire;
import fr.wijin.fiche.fiche.repository.CommentaireRepository;
import fr.wijin.fiche.fiche.repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CommentaireService {

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private CommentaireMapper commentaireMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public List<CommentaireDto> findAll() {
		return commentaireRepository
				.findAll()
				.stream()
				.map(commentaireMapper::mapCommentaireToCommentaireDto)
				.toList();
	}

	public Optional<CommentaireDto> findById(Integer id) {
		Commentaire commentaire = commentaireRepository.findById(id)
				.orElse(null);
		if (commentaire == null) {
			return Optional.ofNullable((CommentaireDto) null);
		}
		return Optional.of(
				commentaireMapper.mapCommentaireToCommentaireDto(commentaire));
	}

	public void delete(CommentaireDto commentaire) {
		this.commentaireRepository.deleteById(commentaire.getId().intValue());
	}

	public CommentaireDto save(CommentaireDto commentaire) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			commentaire.setAuteurCommentaire(
					userMapper.mapUserToUserDto(userRepository.findByUsername(authentication.getName())));
		}
		commentaire.setDate(LocalDateTime.now());
		return commentaireMapper.mapCommentaireToCommentaireDto(this.commentaireRepository.save(
				commentaireMapper.mapCommentaireDtoToCommentaire(commentaire)));
	}
}
