package com.br.fontinhas.fontes.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class User2Test {


    @Test
    void should_not_access_information(){

        User2 userDeTeste = new User2();

        userDeTeste.setAge(40);

        assertEquals(30, userDeTeste.getWomanAge());

    }

}