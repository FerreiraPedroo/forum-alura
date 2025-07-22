package br.com.alura.forum_alura.model;

import br.com.alura.forum_alura.DTO.DadosTopicoCadastrar;
import jakarta.persistence.*;
import lombok.*;

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
    private String data_criacao;
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
        this.data_criacao = LocalDateTime.now().toString();
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

}
