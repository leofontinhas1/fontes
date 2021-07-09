package com.br.fontinhas.fontes.controller;

import com.br.fontinhas.fontes.Constants;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.gateway.UserGateway;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
class UserControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserGateway userGateway;

    @Test
    void should_get_a_user() throws Exception, LocalizedException {

        when(userGateway.getUserById(anyLong())).thenReturn(Constants.userDTO);

        MvcResult result = mockMvc.perform(get("/api/user/1").contentType("application/json").accept("application/json"))
                .andExpect(status().isOk()).andReturn();
        String expectedResponseBody = mapper.writeValueAsString(Constants.userDTO);
        String actualResponseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody,actualResponseBody);
    }

    @Test
    void should_get_a_list_of_users() throws Exception, LocalizedException {

        when(userGateway.getAllUsers()).thenReturn(List.of(Constants.userDTO));

        MvcResult result = mockMvc.perform(get("/api/user/list").contentType("application/json").accept("application/json"))
                .andExpect(status().isOk()).andReturn();
        String expectedResponseBody = mapper.writeValueAsString(List.of(Constants.userDTO));
        String actualResponseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody,actualResponseBody);
    }

    @Test
    void should_create_a_users() throws Exception, LocalizedException {

        when(userGateway.createUser(any())).thenReturn(Constants.userDTO);

        MvcResult result = mockMvc
                .perform(
                    post("/api/user/")
                            .contentType("application/json")
                            .accept("application/json")
                            .content(mapper.writeValueAsString(Constants.userDTO)
                            )
                ).andExpect(status().isCreated()).andReturn();

        String expectedResponseBody = mapper.writeValueAsString(Constants.userDTO);
        String actualResponseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody,actualResponseBody);
    }

    @Test
    void should_get_status_204_on_getByID() throws Exception, LocalizedException {

        when(userGateway.getUserById(anyLong())).thenThrow(new LocalizedException("id não encontrado", HttpStatus.NO_CONTENT));

        mockMvc.perform(get("/api/user/1").contentType("application/json").accept("application/json"))
                .andExpect(status().isNoContent()).andReturn();
    }

    @Test
    void should_get_status_204_on_getAllUsers() throws Exception, LocalizedException {

        when(userGateway.getAllUsers()).thenThrow(new LocalizedException("id não encontrado", HttpStatus.NO_CONTENT));

        mockMvc.perform(get("/api/user/list").contentType("application/json").accept("application/json"))
                .andExpect(status().isNoContent()).andReturn();

    }




}