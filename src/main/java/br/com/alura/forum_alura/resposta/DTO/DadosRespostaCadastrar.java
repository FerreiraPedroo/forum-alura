package br.com.alura.forum_alura.resposta.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosRespostaCadastrar(
        @NotEmpty
        String mensagem,
        @NotNull
        Long topico,
        @NotNull
        Long autor
) {
}
