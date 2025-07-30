package br.com.alura.forum_alura.perfil.DTO;

import br.com.alura.forum_alura.perfil.Perfil;

public record DadosPerfil(
        Long id,
        String nome
) {
    public DadosPerfil(Perfil perfil) {
        this(
                perfil.getId(),
                perfil.getNome()
        );
    }
}
