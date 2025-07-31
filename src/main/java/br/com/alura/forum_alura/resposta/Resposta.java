package br.com.alura.forum_alura.resposta;

import lombok.Getter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import br.com.alura.forum_alura.usuario.Usuario;
import br.com.alura.forum_alura.topico.Topico;
import br.com.alura.forum_alura.resposta.DTO.DadosRespostaCadastrar;


@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @Column(name = "data_criacao")
    private String dataCriacao;
    private int solucao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Resposta(DadosRespostaCadastrar resposta) {
        this.mensagem = resposta.mensagem();
        this.dataCriacao = LocalDateTime.now().toString();
        this.solucao = 0;
    }

    public void setAutor(Usuario usuario) {
        this.autor = usuario;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public void setMessagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
