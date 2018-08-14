package br.edu.ifpb.ifpbcurso.domain;

import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String abreviacao;
    private int periodo;
    private TipoDisciplina tipo;
    private int cargaHoraria;
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
