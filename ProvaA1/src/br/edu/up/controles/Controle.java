package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivosAluno;
import br.edu.up.daos.GerenciadorDeArquivosResumo;
import br.edu.up.modelos.Aluno;
import br.edu.up.modelos.Turma;

public class Controle {
    
    private GerenciadorDeArquivosAluno leitorA;
    private GerenciadorDeArquivosResumo gravador;
    ArrayList<Aluno> listaAluno = new ArrayList<>();
    ArrayList<Turma> listaTurma = new ArrayList<>();

    public Controle() {
        this.leitorA = new GerenciadorDeArquivosAluno();
        this.gravador = new GerenciadorDeArquivosResumo();
        this.listaAluno = leitorA.getAlunos();
    }

    public void fundirAlunosTurma() {
        int tamanhoTurma = listaAluno.size();

        int reprovado = 0;
        int aprovado = 0;

        double media = 0;

        double maior = 0;
        double menor = 11.0;

        for (Aluno aluno : listaAluno) {
            System.out.println("Processando aluno: " + aluno.getNome() + " com nota: " + aluno.getNota());
            if (aluno.getNota() < 6.0) {
                reprovado++;
                if (aluno.getNota() < menor) {
                    menor = aluno.getNota();
                }
            } else {
                aprovado++;
                if (aluno.getNota() > maior) {
                    maior = aluno.getNota();
                }
            }
            media += aluno.getNota();
        }

        double mediaFinal = media / listaAluno.size();

        System.out.println("Quantidade de alunos: " + tamanhoTurma);
        System.out.println("Quantidade de aprovados: " + aprovado);
        System.out.println("Quantidade de reprovados: " + reprovado);
        System.out.println("Menor nota: " + menor);
        System.out.println("Maior nota: " + maior);
        System.out.println("Média geral: " + mediaFinal);

        Turma turma = new Turma(tamanhoTurma, aprovado, reprovado, menor, maior, mediaFinal);
        listaTurma.add(turma);

        if (gravador.gravar(listaTurma)) {
            System.out.println("Dados gravados com sucesso!");
        } else {
            System.out.println("Falha ao gravar os dados.");
        }
    }
}

