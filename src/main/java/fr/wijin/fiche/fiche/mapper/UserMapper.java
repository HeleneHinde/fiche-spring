package fr.wijin.fiche.fiche.mapper;

import org.springframework.stereotype.Component;

import fr.wijin.fiche.fiche.dto.UserDto;
import fr.wijin.fiche.fiche.model.User;

@Component
public class UserMapper {

    public UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setGrants(user.getGrants());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public User mapUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setGrants(userDto.getGrants());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        return user;
    }

}
