package br.edu.up.controles;
import java.util.List;

import br.edu.up.daos.GerenciadorArquivos;
import br.edu.up.modelos.Aluno;

public class Controle {
    private List<Aluno> alunos;
    private GerenciadorArquivos leitor = new GerenciadorArquivos();
    private int nAlunos = 0;
    private int aprovados = 0;
    private int reprovados = 0;
    private double menorNota = 10;
    private double maiorNota = 0;
    private double soma;
    private double media;

    public void lerAlunos(){
        alunos = leitor.lerAlunos();
    }
    public void calcular(){
        this.nAlunos = alunos.size();
        
        for (Aluno aluno : alunos) {
            if(aluno.getNota() >= 6){
                this.aprovados++;
            }else{
                this.reprovados++;
            }

            if(aluno.getNota() > maiorNota){
                maiorNota = aluno.getNota();
            }
            if(aluno.getNota() < menorNota){
                menorNota = aluno.getNota();
            }

            soma += aluno.getNota();
        }

        this.media = soma/nAlunos;
        
    }
    public void gravar(){
        if(leitor.guardar(nAlunos, aprovados, reprovados, menorNota, maiorNota, media)){
            System.out.println("guardado com sucesso");
        }else{
            System.out.println("erro ao guardar");
        }
    }
}