package com.br.fontinhas.fontes;

import com.br.fontinhas.fontes.gateway.dto.UserDTO;
import com.br.fontinhas.fontes.entity.User;

public final class Constants {

    public static final User user = User.Builder.aUser().withName("Ricardo").withUsername("Rico").withPassword("SenhaForte123").build();

    public static final UserDTO userDTO = new UserDTO(user.getName(),user.getUsername(),user.getPassword());


}
