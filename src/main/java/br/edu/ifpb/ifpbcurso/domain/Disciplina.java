package br.edu.ifpb.ifpbcurso.domain;

import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplinas_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "disciplina_sequence", name = "disciplinas_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String abreviacao;
    @Column(nullable = false)
    private int periodo;
//    @Column(nullable = false)
    @Enumerated
    private TipoDisciplina tipo;
    @Column(nullable = false)
    private int cargaHoraria;
    @Column(nullable = false)
    private int aulasSemana;

    @ManyToOne
    private Curso curso;

    public Disciplina () {

    }

    public Disciplina(String nome, String abreviacao, int periodo, TipoDisciplina tipo, int cargaHoraria, int aulasSemana) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.periodo = periodo;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.aulasSemana = aulasSemana;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", abreviacao='" + abreviacao + '\'' +
                ", periodo=" + periodo +
                ", tipo=" + tipo +
                ", cargaHoraria=" + cargaHoraria +
                ", aulasSemana=" + aulasSemana +
                '}';
    }
}
