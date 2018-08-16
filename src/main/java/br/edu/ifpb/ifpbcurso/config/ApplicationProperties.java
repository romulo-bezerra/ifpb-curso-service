package br.edu.ifpb.ifpbcurso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cursoservice")
public class ApplicationProperties {

    private Csv csv = new Csv();

    public final class Csv {

        private String disciplina;
        private String curso;
        private String unidade;

        public String getDisciplina() {
            return disciplina;
        }

        public void setDisciplina(String disciplina) {
            this.disciplina = disciplina;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getUnidade() {
            return unidade;
        }

        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }
    }

    public Csv getCsv() {
        return csv;
    }

    public void setCsv(Csv csv) {
        this.csv = csv;
    }
}
