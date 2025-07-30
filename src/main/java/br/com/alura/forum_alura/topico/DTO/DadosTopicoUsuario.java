package br.com.alura.forum_alura.topico.DTO;

import br.com.alura.forum_alura.usuario.Usuario;

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
