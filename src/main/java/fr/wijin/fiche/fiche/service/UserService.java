package fr.wijin.fiche.fiche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wijin.fiche.fiche.dto.UserDto;
import fr.wijin.fiche.fiche.mapper.UserMapper;
import fr.wijin.fiche.fiche.model.User;
import fr.wijin.fiche.fiche.repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::mapUserToUserDto)
                .toList();
    }

    public Optional<UserDto> findById(Integer id) {
        User user = userRepository.findById(id)
                .orElse(null);
        if (user == null) {
            return Optional.ofNullable((UserDto) null);
        }
        return Optional.of(
                userMapper.mapUserToUserDto(user));
    }

    public void delete(UserDto user) {
        this.userRepository.deleteById(user.getId().intValue());
    }

    public UserDto save(UserDto user) {
        return userMapper.mapUserToUserDto(this.userRepository.save(
                userMapper.mapUserDtoToUser(user)));
    }
}
