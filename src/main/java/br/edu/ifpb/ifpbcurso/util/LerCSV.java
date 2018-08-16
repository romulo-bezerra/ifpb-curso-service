package br.edu.ifpb.ifpbcurso.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LerCSV {

    public List<String[]> lerCsv(String arquivo){

        List<String[]> retorno = new ArrayList<>();

        BufferedReader conteudoCsv = null;

        String linha = "";

        String csvSeparadorCampo = ",";

        try {
            conteudoCsv = new BufferedReader(new FileReader(new ClassPathResource(arquivo).getFile()));
            while ((linha = conteudoCsv.readLine()) != null) {

                String[] moeda = linha.split(csvSeparadorCampo);
                retorno.add(moeda);

            }
            return retorno;

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: \n"+e.getMessage());
            return retorno;
        } catch (IOException e) {
            System.out.println("IO erro: \n"+e.getMessage());
            return retorno;
        } finally {
            if (conteudoCsv != null){
                try {
                    conteudoCsv.close();
                } catch (IOException e) {
                    System.out.println("IO erro: \n"+e.getMessage());
                }
            }
        }

    }

}
