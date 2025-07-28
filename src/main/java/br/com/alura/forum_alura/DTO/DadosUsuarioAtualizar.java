package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Usuario;
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
