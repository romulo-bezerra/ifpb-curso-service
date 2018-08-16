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

    //codigo,unidade,descricao,abreviacao,periodos

    @Idit
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "curso_sequence", name = "curso_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String abreviacao;
    @Column(nullable = false)
    private int periodos;
//    @Column(nullable = false)
    private String pagina;
//    @Column(nullable = false)
    private String grandeAreaId;

    @OneToMany
    @JoinColumn(name="curso")
    private List<Disciplina> disciplinas;

    @ManyToOne
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
