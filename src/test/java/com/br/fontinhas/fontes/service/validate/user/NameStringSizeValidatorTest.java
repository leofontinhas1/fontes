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
class NameStringSizeValidatorTest {

    @InjectMocks
    private NameStringSizeValidator validator;

    @Test
    void should_throw_an_exception_when_name_length_bigger_than_255() {

        String stringWith256Characters = "alksjfçlksjdfçlaksjdfçlkasjdfçlkajsçdlfkjaçslkjfçlaskjdfçlaksjdfçlaksjdçflkajsdçflkjasdlçfkjaçslkdfjçalskdjfçlaksjdfçlaksjdfçlkasjdçflkajsdçflkjasdçlfkjaçsldkfjçalsdkjfçlsakjdfçlaksdjfçlaksjdfçlkajsdfçlkjasçdlkfjaçslkdfjçaslkdjalskjdfjlaksjdçlfkjalkjasdflkj";
        User user = User.Builder.aUser().withName(stringWith256Characters)
                .withUsername("test")
                .withPassword("test123")
                .build();


        LocalizedException localizedException = assertThrows(LocalizedException.class, () -> {
            validator.validate(user);
        });

        assertEquals("error.user.nameStringLengthBiggerThen255", localizedException.getMessage());
        assertEquals(HttpStatus.PRECONDITION_FAILED, localizedException.getStatus());


    }
}