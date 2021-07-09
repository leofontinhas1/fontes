package com.br.fontinhas.fontes.controller;

import com.br.fontinhas.fontes.dto.UserDTO;
import com.br.fontinhas.fontes.entity.User;
import com.br.fontinhas.fontes.repository.UserRepository;
import com.br.fontinhas.fontes.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTranslator userTranslator;

    @GetMapping("/{id}")
    public ResponseEntity geUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userRepository.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }
    @GetMapping("/list")
    public ResponseEntity listUsers(){
        try{
            return ResponseEntity.ok().body(userRepository.findAll());
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        try{
            User user = userRepository.save(userTranslator.toEntity(userDTO));
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

}
