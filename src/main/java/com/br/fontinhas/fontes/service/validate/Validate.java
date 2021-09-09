package com.br.fontinhas.fontes.service.validate;

import com.br.fontinhas.fontes.exeption.LocalizedException;

public interface Validate<Entity> {

    void validate(Entity entity) throws LocalizedException;

}
