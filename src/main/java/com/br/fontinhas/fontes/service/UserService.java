package com.br.fontinhas.fontes.service;

import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserById(final Long id) throws LocalizedException {

        final Optional<User> user = repository.findById(id);

        if(user.isPresent()){return user.get();}

        throw new LocalizedException("id não encontrado", HttpStatus.NO_CONTENT);
    }

    public List<User> getAllUsers() throws LocalizedException{
        final List<User> users = repository.findAll();

        if(!users.isEmpty()){
            return users;
        }

        throw new LocalizedException("não existe nenhum usuário cadastrado", HttpStatus.NO_CONTENT);
    }

    @Transactional
    public User createUser(User user)  {
        return repository.save(user);
    }
}
