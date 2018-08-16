package br.edu.ifpb.ifpbcurso;

import br.edu.ifpb.ifpbcurso.config.ApplicationProperties;
import br.edu.ifpb.ifpbcurso.domain.Curso;
import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.domain.Unidade;
import br.edu.ifpb.ifpbcurso.domain.enums.TipoDisciplina;
import br.edu.ifpb.ifpbcurso.repository.CursoRepository;
import br.edu.ifpb.ifpbcurso.service.CursoService;
import br.edu.ifpb.ifpbcurso.util.LerCSV;
import br.edu.ifpb.ifpbcurso.util.RestoreByCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication
public class IfpbCursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IfpbCursoApplication.class, args);
    }
}
