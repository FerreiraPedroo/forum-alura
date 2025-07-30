package br.com.alura.forum_alura.curso.DTO;

import br.com.alura.forum_alura.curso.Curso;
import jakarta.validation.constraints.NotEmpty;

public record DadosCurso(
        Long id,
        @NotEmpty
        String nome,
        String categoria
) {
    public DadosCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getCategoria()
        );
    }
}
