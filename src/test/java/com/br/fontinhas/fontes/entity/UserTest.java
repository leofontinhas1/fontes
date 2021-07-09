package com.br.fontinhas.fontes.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserTest {

    @Test
    public void shouldCreateUser(){

        User user = User.Builder.aUser().withName("leonardo").withUsername("leo").withPassword("!@#Mudar").build();
        assertNotNull(user);
        assertEquals("leonardo",user.getName());
        assertEquals("leo",user.getUsername());
        assertEquals("!@#Mudar",user.getPassword());
    }

}