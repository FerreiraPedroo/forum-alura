package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Curso;
import br.com.alura.forum_alura.model.Perfil;
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
