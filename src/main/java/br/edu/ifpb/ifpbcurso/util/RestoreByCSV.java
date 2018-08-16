package br.edu.ifpb.ifpbcurso.util;

import br.edu.ifpb.ifpbcurso.config.ApplicationProperties;
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

    private final CursoService cursoService;
    private final DisciplinaService disciplinaService;
    private final UnidadeService unidadeService;
    private final LerCSV lerCSV;
    private final ApplicationProperties applicationProperties;

    public RestoreByCSV(CursoService cursoService, DisciplinaService disciplinaService, UnidadeService unidadeService, LerCSV lerCSV, ApplicationProperties applicationProperties) {
        this.cursoService = cursoService;
        this.disciplinaService = disciplinaService;
        this.unidadeService = unidadeService;
        this.lerCSV = lerCSV;
        this.applicationProperties = applicationProperties;
    }

    public void restaurarUnidadesCsv() {

        List<String[]> lista = lerCSV.lerCsv(applicationProperties.getCsv().getUnidade());

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

    public void restaurarCursosCsv() {


        List<String[]> lista = lerCSV.lerCsv(applicationProperties.getCsv().getCurso());

        //codigo,unidade,descricao,abreviacao,periodos

        for (String[] ls: lista) {

            System.out.println("\nCodigo= "+ls[0]+" unidade= "+ls[1]+" nome= "+ls[2]+" abreviacao= "+ls[3]+" periodos= "+ls[4]+"\n");

            Long unidadeId = Long.parseLong(ls[1]);
            String nome = ls[2];
            String abreviacao = ls[3];
            int periodos = Integer.parseInt(ls[4]);

            Unidade unidade = new Unidade();
            unidade.setId(unidadeId);

            Curso curso = new Curso();
            curso.setUnidade(unidade);
            curso.setNome(nome);
            curso.setAbreviacao(abreviacao);
            curso.setPeriodos(periodos);

//            System.out.println(curso.toString()+"\n");

            cursoService.salvarCurso(curso);

        }
    }

    public void restaurarDisciplinasCsv() {

        List<String[]> lista = lerCSV.lerCsv(applicationProperties.getCsv().getDisciplina());

        // codigo,curso,descricao,abreviacao,periodo,carga_horaria,aulas_semana

        for (String[] ls: lista){

            Long codigo = Long.parseLong(ls[0]);
            Curso curso = new Curso();
            curso.setId(Long.parseLong(ls[1]));
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

        }
    }


}
