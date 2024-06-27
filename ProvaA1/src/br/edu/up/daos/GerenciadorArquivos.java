package br.edu.up.daos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Aluno;

public class GerenciadorArquivos {
    private String nomeArquivoAlunos;
    private String nomeArquivoResumo;
    private String header = "Qtd Alunos;Aprovados;Reprovados;Menor Nota;Maior Nota;Media";


    public GerenciadorArquivos(){
        Path caminhoArquivoAlunos = Paths.get("ProvaA1", "src", "br", "edu", "up", "docs", "alunos.csv");
        this.nomeArquivoAlunos = caminhoArquivoAlunos.toAbsolutePath().toString();

        Path caminhoArquivoResumo = Paths.get("ProvaA1","src", "br", "edu", "up", "docs", "resumo.csv");
        this.nomeArquivoResumo = caminhoArquivoResumo.toAbsolutePath().toString();
    }

    public List<Aluno> lerAlunos(){
        List<Aluno> alunos = new ArrayList<>();

        try{
        File arquivoAlunos = new File(nomeArquivoAlunos);
        Scanner leitor = new Scanner(arquivoAlunos);

        String headerAlunos = leitor.nextLine();

        while(leitor.hasNextLine()){
            String linhaAtual = leitor.nextLine();
            String[] dados = linhaAtual.split(";");

            int matricula = Integer.parseInt(dados[0]);
            String nome = dados[1];
            double nota = Double.parseDouble(dados[2]);

            Aluno aluno = new Aluno(matricula, nome, nota);

            alunos.add(aluno);
        }

        leitor.close();
    }catch(FileNotFoundException e){
        System.out.println("Arquivo não encontrado");
    }


        return alunos;
    }

    public boolean guardar(int nAlunos, int aprovados, int reprovados, double menorNota, double maiorNota, double media){

        try{
            
            FileWriter arquivoResumo = new FileWriter(nomeArquivoResumo);
            PrintWriter gravador = new PrintWriter(arquivoResumo);
            String linha =  nAlunos + ";" + aprovados + ";" + reprovados + ";" + menorNota + ";" + maiorNota + ";" + media;
            
            gravador.println(header);
            gravador.println(linha);
            gravador.close();

        }catch(IOException e){
            return false;
        }

        return true;
    }
}
