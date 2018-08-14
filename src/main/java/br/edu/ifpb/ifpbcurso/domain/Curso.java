package br.edu.ifpb.ifpbcurso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String abreviacao;
    private int periodos;
    private String pagina;
    private String grandeAreaId;

    @OneToMany
    private List<Disciplina> disciplinas;

    @OneToOne
    private Unidade unidade;

    public Curso () {
        disciplinas = new ArrayList<>();
    }

}
