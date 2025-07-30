package br.com.alura.forum_alura.curso.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DadosCursoCadastrar(
        @NotEmpty
        String nome,

        @NotEmpty
        String categoria
) {
}
