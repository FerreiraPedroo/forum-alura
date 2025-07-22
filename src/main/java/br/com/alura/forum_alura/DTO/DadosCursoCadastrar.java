package br.com.alura.forum_alura.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DadosCursoCadastrar(
        @NotEmpty
        String nome,

        @NotEmpty
        String categoria
) {
}
