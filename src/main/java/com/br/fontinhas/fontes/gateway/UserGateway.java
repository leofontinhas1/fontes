package com.br.fontinhas.fontes.gateway;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.gateway.dto.UserDTO;
import com.br.fontinhas.fontes.gateway.translator.UserTranslator;
import com.br.fontinhas.fontes.service.UserService;
import com.br.fontinhas.fontes.service.validate.UserValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGateway {

    @Autowired
    private UserValidateService validateService;

    @Autowired
    private UserService service;

    @Autowired
    private UserTranslator translator;

    public UserDTO getUserById(final Long id) throws LocalizedException {
        return translator.toDto(service.getUserById(id));
    }

    public List<UserDTO> getAllUsers() throws LocalizedException{
        return translator.toDto(service.getAllUsers());
    }


    public UserDTO createUser(UserDTO dto) throws LocalizedException{
        User user = translator.toEntity(dto);
        validateService.validate(user);
        return translator.toDto(service.createUser(user));
    }

}
