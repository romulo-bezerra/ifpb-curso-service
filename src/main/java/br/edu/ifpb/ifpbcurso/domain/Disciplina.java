package br.edu.ifpb.ifpbcurso.domain;

import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String abreviacao;
    @Column(nullable = false)
    private int periodo;
    @Column(nullable = false)
    private TipoDisciplina tipo;
    @Column(nullable = false)
    private int cargaHoraria;
    @Column(nullable = false)
    private int aulasSemana;

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
