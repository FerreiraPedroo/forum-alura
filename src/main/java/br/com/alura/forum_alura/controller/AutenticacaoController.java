package br.com.alura.forum_alura.controller;

import org.springframework.security.authentication.AuthenticationManager;
import br.com.alura.forum_alura.DTO.DadosUsuarioAutenticacao;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUsuarioAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
