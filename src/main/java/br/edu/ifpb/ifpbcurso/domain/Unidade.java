package br.edu.ifpb.ifpbcurso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "unidade_sequence", name = "unidade_sequence_gen", allocationSize = 1)
    private Long id;
//    @Column(nullable = false)
    private String nome;

    public Unidade() {

    }

    public Unidade(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
