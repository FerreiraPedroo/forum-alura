package br.com.alura.forum_alura.DTO;

import br.com.alura.forum_alura.model.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record DadosUsuarioCadastrar(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha,

        Long perfil
) {

}
