package br.com.alura.forum_alura.model;

import br.com.alura.forum_alura.DTO.DadosNovoTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String dataCriacao;
    private String status;
    private Long autor;
    private Long curso;
    private Long respostas;

    public Topico(DadosNovoTopico cadastro) {
        this.titulo = cadastro.titulo();
        this.mensagem = cadastro.mensagem();
        this.autor = cadastro.autor();
        this.curso = cadastro.curso();
    }

}
