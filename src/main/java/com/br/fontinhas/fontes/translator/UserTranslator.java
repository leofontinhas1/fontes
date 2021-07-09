package com.br.fontinhas.fontes.translator;

import com.br.fontinhas.fontes.dto.UserDTO;
import com.br.fontinhas.fontes.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTranslator implements Translator<User, UserDTO> {

    @Override
    public User toEntity(UserDTO dto) {
        return User.Builder.aUser()
                .withName(dto.getName())
                .withUsername(dto.getUsername())
                .withPassword(dto.getPassword())
                .build();
    }

    @Override
    public UserDTO toDto(User user) {
        return new UserDTO(user.getName(),user.getUsername(),user.getPassword());
    }
}
