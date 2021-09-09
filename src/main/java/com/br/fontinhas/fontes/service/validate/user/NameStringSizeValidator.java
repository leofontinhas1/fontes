package com.br.fontinhas.fontes.service.validate.user;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.service.validate.Validate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NameStringSizeValidator implements Validate<User> {

    @Override
    public void validate(final User user) throws LocalizedException{
        if(isNameLengthBiggerThen255(user)){
            throw new LocalizedException("error.user.nameStringLengthBiggerThen255", HttpStatus.PRECONDITION_FAILED);
        }
    }

    private boolean isNameLengthBiggerThen255(User user) {
        return user.getName().trim().length() > 255;
    }
}
