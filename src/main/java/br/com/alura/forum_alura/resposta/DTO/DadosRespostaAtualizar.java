package br.com.alura.forum_alura.resposta.DTO;

import jakarta.validation.constraints.NotEmpty;

public record DadosRespostaAtualizar(
        @NotEmpty
        String mensagem
) {
}
