package br.edu.ifpb.ifpbcurso.util;

import br.edu.ifpb.ifpbcurso.domain.Curso;
import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.domain.Unidade;
import br.edu.ifpb.ifpbcurso.service.CursoService;
import br.edu.ifpb.ifpbcurso.service.DisciplinaService;
import br.edu.ifpb.ifpbcurso.service.UnidadeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestoreByCSV {

    private static CursoService cursoService;

    private static DisciplinaService disciplinaService;

    private static UnidadeService unidadeService;

    public RestoreByCSV (CursoService cursoService, DisciplinaService disciplinaService, UnidadeService unidadeService) {
        this.cursoService = cursoService;
        this.disciplinaService = disciplinaService;
        this.unidadeService = unidadeService;
    }

    public static void restaurarUnidadesCsv() {

        List<String[]> lista = LerCSV.lerCsv("/home/romulo/Área de Trabalho/ifpb-curso-service/csv's/unidade.csv");

        //codigo,descricao,abreviacao

        for (String[] ls: lista){
            Long codigo = Long.parseLong(ls[0]);
            String nome = ls[1];

            Unidade unidade = new Unidade();
            unidade.setId(codigo);
            unidade.setNome(nome);

            unidadeService.salvarUnidade(unidade);

            unidade = new Unidade();

        }
    }

    public static void restaurarCursosCsv() {

        List<String[]> lista = LerCSV.lerCsv("/home/romulo/Área de Trabalho/ifpb-curso-service/csv's/curso.csv");

        //codigo,unidade,descricao,abreviacao,periodos

        for (String[] ls: lista){

            Long codigo = Long.parseLong(ls[0]);
            Long unidadeId = Long.parseLong(ls[1]);
            String nome = ls[2];
            String abreviacao = ls[3];
            int periodos = Integer.parseInt(ls[4]);

            Unidade unidade = new Unidade();
            unidade.setId(unidadeId);

            Curso curso = new Curso();
            curso.setId(codigo);
            curso.setUnidade(unidade);
            curso.setNome(nome);
            curso.setAbreviacao(abreviacao);
            curso.setPeriodos(periodos);

            cursoService.salvarCurso(curso);

            curso = new Curso();

        }
    }

    public static void restaurarDisciplinasCsv() {

        List<String[]> lista = LerCSV.lerCsv("/home/romulo/Área de Trabalho/ifpb-curso-service/csv's/disciplina.csv");

        // codigo,curso,descricao,abreviacao,periodo,carga_horaria,aulas_semana

        for (String[] ls: lista){

            Long codigo = Long.parseLong(ls[0]);
            Long curso = Long.parseLong(ls[1]);
            String nome = ls[2];
            String abreviacao = ls[3];
            int periodo = Integer.parseInt(ls[4]);
            int cargaHoraria = Integer.parseInt(ls[5]);
            int aulasSemana = Integer.parseInt(ls[6]);

            Disciplina disciplina = new Disciplina();
            disciplina.setId(codigo);
            disciplina.setCurso(curso);
            disciplina.setNome(nome);
            disciplina.setAbreviacao(abreviacao);
            disciplina.setPeriodo(periodo);
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setAulasSemana(aulasSemana);

            disciplinaService.salvarDisciplina(disciplina);

            disciplina = new Disciplina();

        }
    }


}
