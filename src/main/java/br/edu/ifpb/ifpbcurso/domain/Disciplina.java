package br.edu.ifpb.ifpbcurso.domain;

import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
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

}
