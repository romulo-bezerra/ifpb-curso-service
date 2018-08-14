package br.edu.ifpb.ifpbcurso.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
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

    public Curso(String nome, String abreviacao, int periodos, String pagina, String grandeAreaId, Unidade unidade) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.periodos = periodos;
        this.pagina = pagina;
        this.grandeAreaId = grandeAreaId;
        this.unidade = unidade;
    }

    public boolean addDisciplina (Disciplina disciplina){
        return disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", abreviacao='" + abreviacao + '\'' +
                ", periodos=" + periodos +
                ", pagina='" + pagina + '\'' +
                ", grandeAreaId='" + grandeAreaId + '\'' +
                ", disciplinas=" + disciplinas +
                ", unidade=" + unidade +
                '}';
    }
}
