package br.com.alura.forum_alura.service;

import br.com.alura.forum_alura.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorio.findByEmail(username);
    }
}
