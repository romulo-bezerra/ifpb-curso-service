package br.edu.ifpb.ifpbcurso;

import br.edu.ifpb.ifpbcurso.domain.Curso;
import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.domain.Unidade;
import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class IfpbCursoApplication {

    public static void main(String[] args) {

        Unidade unidade = new Unidade();
        unidade.setNome("teste");

        Disciplina disciplina = new Disciplina();
        disciplina.setAbreviacao("RHT");
        disciplina.setAulasSemana(6);
        disciplina.setCargaHoraria(5);
        disciplina.setNome("Recursos Humanos no Trabalho");
        disciplina.setPeriodo(6);
        disciplina.setTipo(TipoDisciplina.OBRIGATORIA);

        Disciplina disciplina1 = new Disciplina();
        disciplina.setAbreviacao("ES");
        disciplina.setAulasSemana(6);
        disciplina.setCargaHoraria(5);
        disciplina.setNome("Estágio");
        disciplina.setPeriodo(6);
        disciplina.setTipo(TipoDisciplina.OPTATIVA);

        Curso curso = new Curso();
        curso.setAbreviacao("ADS");
        curso.setGrandeAreaId("Informática");
        curso.setNome("Análise e Desenvolvimento de Sistemas");
        curso.setPagina("");
        curso.setPeriodos(6);
        curso.setUnidade(unidade);
        curso.addDisciplina(disciplina);
        curso.addDisciplina(disciplina1);

        System.out.printf("Estes é o CURSO: " + curso.toString());

        SpringApplication.run(IfpbCursoApplication.class, args);
    }
}
