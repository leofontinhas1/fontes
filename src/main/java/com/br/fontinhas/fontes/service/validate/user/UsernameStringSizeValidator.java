package com.br.fontinhas.fontes.service.validate.user;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.service.validate.Validate;
import org.springframework.http.HttpStatus;

public class UsernameStringSizeValidator implements Validate<User> {

    @Override
    public void validate(final User user) throws LocalizedException{
        if(isNameLengthBiggerThen255(user.getName())){
            throw new LocalizedException("error.user.nameStringLengthBiggerThen255", HttpStatus.PRECONDITION_FAILED);
        }
    }

    private boolean isNameLengthBiggerThen255(final String name) {
        return name.trim().length() > 255;
    }
}
