package br.com.alura.forum_alura.topico.DTO;

import br.com.alura.forum_alura.curso.Curso;

public record DadosTopicoCurso(
        Long id,
        String nome,
        String categoria
) {
    public  DadosTopicoCurso(Curso dados){
        this(
                dados.getId(),
                dados.getNome(),
                dados.getCategoria()
        );
    }
}
