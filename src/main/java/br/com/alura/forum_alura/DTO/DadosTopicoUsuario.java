package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Usuario;

public record DadosTopicoUsuario(
        Long id,
        String nome
) {
    public DadosTopicoUsuario(Usuario dados){
        this(
                dados.getId(),
                dados.getNome()
        );
    }
}
