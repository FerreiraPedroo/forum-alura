package br.com.alura.forum_alura.topico.DTO;

public record DadosTopicoAtualizar(
        String titulo,
        String mensagem,
        String status,
        Long curso
) {
}
