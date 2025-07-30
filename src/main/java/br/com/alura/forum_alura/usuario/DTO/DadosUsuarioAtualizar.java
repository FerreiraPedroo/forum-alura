package br.com.alura.forum_alura.usuario.DTO;

import br.com.alura.forum_alura.usuario.Usuario;
import jakarta.validation.constraints.NotEmpty;

public record DadosUsuarioAtualizar(
        @NotEmpty
        String nome

) {
    public DadosUsuarioAtualizar(Usuario usuario) {
        this(
                usuario.getNome()
        );
    }
}
