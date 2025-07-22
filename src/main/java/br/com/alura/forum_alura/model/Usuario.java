package br.com.alura.forum_alura.model;

import br.com.alura.forum_alura.DTO.DadosUsuarioCadastrar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @ManyToOne
    private Perfil perfil;

    @OneToMany(mappedBy = "autor")
    private List<Resposta> respostas;


    public Usuario(DadosUsuarioCadastrar dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void setPerfil(Perfil perfil){
        this.perfil = perfil;
    }

}
