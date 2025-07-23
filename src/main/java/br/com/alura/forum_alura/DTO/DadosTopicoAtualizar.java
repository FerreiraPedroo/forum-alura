package br.com.alura.forum_alura.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosTopicoAtualizar(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String status,
        Long curso
) {
}
