package com.br.fontinhas.fontes.translator;

import java.util.List;
import java.util.stream.Collectors;

public interface Translator <Entity,Dto>{

    Entity toEntity(Dto dto);

    Dto toDto(Entity e);

    default List<Entity> toEntity(List<Dto> dtos){
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<Dto> toDto(List<Entity> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }



}
