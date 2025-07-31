package br.com.alura.forum_alura.resposta.DTO;

import br.com.alura.forum_alura.resposta.Resposta;
import br.com.alura.forum_alura.topico.DTO.DadosTopico;
import br.com.alura.forum_alura.topico.DTO.DadosTopicoUsuario;

public record DadosResposta(
        Long id,
        String mensagem,
        String dataCriacao,
        DadosTopico topico,
        DadosTopicoUsuario autor,
        int solucao
) {
    public DadosResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao().toString(),
                new DadosTopico(resposta.getTopico()),
                new DadosTopicoUsuario(resposta.getAutor()),
                resposta.getSolucao()
        );
    }

}
