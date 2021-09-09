package com.br.fontinhas.fontes.service.validate.user;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
class PasswordEspecialCharactersValidatorTest {

    @InjectMocks
    private PasswordEspecialCharactersValidator validator;

    @Test
    void should_throw_an_LocalizedException(){

        User user = User.Builder.aUser().withName("test").withUsername("tst").withPassword("senhafraca").build();
        String expectedMessage = "error.user.especialCharacterRequiredInPassword";
        HttpStatus expectedHttpStatus = HttpStatus.PRECONDITION_FAILED;

        LocalizedException exception = assertThrows(LocalizedException.class,()->{
            validator.validate(user);
        });

        assertEquals(expectedMessage,exception.getMessage());
        assertEquals(expectedHttpStatus,exception.getStatus());
    }

}
