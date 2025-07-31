package br.com.alura.forum_alura.curso;

import br.com.alura.forum_alura.curso.DTO.DadosCursoCadastrar;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Getter;

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
