package br.com.alura.forum_alura.usuario;

import br.com.alura.forum_alura.usuario.DTO.DadosUsuarioAtualizar;
import br.com.alura.forum_alura.usuario.DTO.DadosUsuarioCadastrar;
import br.com.alura.forum_alura.perfil.Perfil;
import br.com.alura.forum_alura.resposta.Resposta;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void atualizarInformacoes(@Valid DadosUsuarioAtualizar dados) {
            this.nome = dados.nome();
    }
}
