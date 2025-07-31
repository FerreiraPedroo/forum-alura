package br.com.alura.forum_alura.perfil;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import br.com.alura.forum_alura.usuario.Usuario;
import br.com.alura.forum_alura.perfil.DTO.DadosPerfilCadastrar;

import java.util.List;

@Table(name = "perfil")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;

    @OneToMany(mappedBy = "perfil")
    List<Usuario> usuarios;

    public Perfil(DadosPerfilCadastrar dados) {
        this.nome = dados.nome();
    }
}
