package br.com.alura.forum_alura.DTO;

import java.util.List;

public record DadosTopico(
        Long id,
        String titulo,
        String mensagem,
        String data_criacao,
        String status,
        DadosTopicoAutor autor,
        DadosTopicoCurso curso,
        List<DadosTopicoRespostas> respostas
) {
}
