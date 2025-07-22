package br.com.alura.forum_alura.model;

import br.com.alura.forum_alura.DTO.DadosCursoCadastrar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@jsonAlias = para mudar o nome do campo na declaração \/

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;

    public Curso(DadosCursoCadastrar dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
