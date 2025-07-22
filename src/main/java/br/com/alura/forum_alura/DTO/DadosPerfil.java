package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Perfil;
import jakarta.validation.constraints.NotEmpty;

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
