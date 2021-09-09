package com.br.fontinhas.fontes.service.validate;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserValidateService {

    @Autowired
    List<Validate<User>> validates;

    public void validate(final User user) throws LocalizedException{
        validates.forEach(v -> v.validate(user));
    }


}
