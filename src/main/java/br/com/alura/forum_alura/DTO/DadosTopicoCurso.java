package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Curso;

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
