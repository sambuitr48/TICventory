package co.cue.edu.ticventory.ticventory.auth.mapper;


import co.cue.edu.ticventory.ticventory.auth.domain.AuthRole;
import co.cue.edu.ticventory.ticventory.auth.dto.UserDTO;
import co.cue.edu.ticventory.ticventory.auth.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRole().name(), user.getPassword());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), AuthRole.valueOf(userDTO.getRole()));
    }
}
