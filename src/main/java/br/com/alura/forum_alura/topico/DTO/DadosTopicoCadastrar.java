package br.com.alura.forum_alura.topico.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosTopicoCadastrar(
        @NotEmpty
        String titulo,
        @NotEmpty
        String mensagem,
        @NotNull
        Long autor,
        @NotNull
        Long curso
) {
}
