package br.com.alura.forum_alura.topico.DTO;

public record DadosTopicoRespostas(
        Long id,
        String mensagem,
        String dataCriacao,
        DadosTopicoUsuario autor,
        int solucao
) {

}
