package br.edu.ifpb.ifpbcurso.config;

import br.edu.ifpb.ifpbcurso.util.RestoreByCSV;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInit implements ApplicationListener<ContextRefreshedEvent> {

    private final RestoreByCSV restoreByCSV;

    public ApplicationInit(RestoreByCSV restoreByCSV) {
        this.restoreByCSV = restoreByCSV;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        restoreByCSV.restaurarUnidadesCsv();
        restoreByCSV.restaurarCursosCsv();
        restoreByCSV.restaurarDisciplinasCsv();
    }

}
