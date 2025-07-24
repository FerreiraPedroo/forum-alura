package br.com.alura.forum_alura.DTO;

public record DadosTopicoRespostas(
        Long id,
        String mensagem,
        String data_criacao,
        DadosTopicoUsuario autor,
        Boolean solucao
) {
}
