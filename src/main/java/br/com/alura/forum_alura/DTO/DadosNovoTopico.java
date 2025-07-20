package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosNovoTopico(
        String titulo,
        String mensagem,
        Long autor,
        Long curso
) {
    public DadosNovoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
