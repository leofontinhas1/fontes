package com.br.fontinhas.fontes.controller;

import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.gateway.UserGateway;
import com.br.fontinhas.fontes.gateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserGateway userGateway;

    @GetMapping("/{id}")
    public ResponseEntity geUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userGateway.getUserById(id));
        }catch (LocalizedException le){
            return ResponseEntity.status(le.getStatus()).body(le.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }
    @GetMapping("/list")
    public ResponseEntity listUsers(){
        try{
            return ResponseEntity.ok().body(userGateway.getAllUsers());
        }catch (LocalizedException le){
            return ResponseEntity.status(le.getStatus()).body(le.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(userGateway.createUser(userDTO));
        }catch (LocalizedException le){
            return ResponseEntity.status(le.getStatus()).body(le.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

}
