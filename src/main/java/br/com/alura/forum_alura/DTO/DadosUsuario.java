package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Usuario;

public record DadosUsuario(
        Long id,
        String nome,
        String email,
        DadosPerfil perfil
) {
    public DadosUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                new DadosPerfil(usuario.getPerfil().getId(), usuario.getPerfil().getNome())
        );
    }
}
