package br.com.alura.forum_alura.topico;

import lombok.*;
import jakarta.persistence.*;
import br.com.alura.forum_alura.curso.Curso;
import br.com.alura.forum_alura.usuario.Usuario;
import br.com.alura.forum_alura.resposta.Resposta;
import br.com.alura.forum_alura.topico.DTO.DadosTopicoAtualizar;
import br.com.alura.forum_alura.topico.DTO.DadosTopicoCadastrar;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @Column(name = "data_criacao")
    private String dataCriacao;
    private String status;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico(DadosTopicoCadastrar cadastro) {
        this.titulo = cadastro.titulo();
        this.mensagem = cadastro.mensagem();
        this.dataCriacao = LocalDateTime.now().toString();
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setResposta(List<Resposta> resposta) {
        this.respostas = resposta;
    }

    public void atualizarInformacoes(DadosTopicoAtualizar dados) {
        if (dados.titulo() != null) this.titulo = dados.titulo();
        if (dados.mensagem() != null) this.mensagem = dados.mensagem();
        if (dados.status() != null) this.status = dados.status();
    }

}
