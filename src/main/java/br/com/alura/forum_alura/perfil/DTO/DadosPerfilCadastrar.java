package br.com.alura.forum_alura.perfil.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DadosPerfilCadastrar(
        @NotEmpty
        String nome
) {
}
