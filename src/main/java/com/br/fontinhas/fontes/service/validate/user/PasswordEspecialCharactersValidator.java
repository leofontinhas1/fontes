package com.br.fontinhas.fontes.service.validate.user;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.service.validate.Validate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordEspecialCharactersValidator implements Validate<User> {

    @Override
    public void validate(User user) throws LocalizedException {
        if (passwordDontHaveAnyEspecialCharacter(user.getPassword())){
            throw new LocalizedException("error.user.especialCharacterRequiredInPassword", HttpStatus.PRECONDITION_FAILED);
        }
    }

    private boolean passwordDontHaveAnyEspecialCharacter(final String password) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        return !m.find();
    }
}
