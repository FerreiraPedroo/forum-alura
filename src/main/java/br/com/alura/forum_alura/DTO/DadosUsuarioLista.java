package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Usuario;

public record DadosUsuarioLista(
        Long id,
        String nome,
        String email,
        DadosPerfil perfil
) {
    public DadosUsuarioLista(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                new DadosPerfil(usuario.getPerfil().getId(), usuario.getPerfil().getNome())
        );
    }
}
