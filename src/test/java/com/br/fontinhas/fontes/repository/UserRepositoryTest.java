package com.br.fontinhas.fontes.repository;

import com.br.fontinhas.fontes.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class UserRepositoryTest {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:11")
            .withUsername("username")
            .withPassword("password")
            .withDatabaseName("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username",container::getUsername);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    void should_get_user_with_id_1() throws Exception{

        User user = userRepository.save(User.Builder.aUser().withName("teste").withUsername("tst").withPassword("123").build());
        Assertions.assertEquals("teste",user.getName());
        Assertions.assertEquals(1,user.getId());
    }

}