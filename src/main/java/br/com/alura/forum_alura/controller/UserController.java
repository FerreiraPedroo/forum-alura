package br.com.alura.forum_alura.controller;

import br.com.alura.forum_alura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;


    @PostMapping
//    @Transactional
    public ResponseEntity userRegister(){

        return ResponseEntity.ok().build();
    }

    @PostMapping("login")
    public ResponseEntity userLogin(){
        return ResponseEntity.ok().build();
    }

}
