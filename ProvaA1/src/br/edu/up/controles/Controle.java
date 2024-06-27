package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivosAluno;
import br.edu.up.daos.GerenciadorDeArquivosResumo;
import br.edu.up.modelos.*;

public class Controle {
    
    private GerenciadorDeArquivosAluno leitorA;
    private GerenciadorDeArquivosResumo gravador;
    ArrayList<Aluno> listaAluno = new ArrayList<>();
    Turma turma;

    public Controle() {
        this.leitorA = new GerenciadorDeArquivosAluno();
        this.gravador = new GerenciadorDeArquivosResumo();
        this.listaAluno = leitorA.getAlunos();
    }

    public void fundirAlunosTurma() {
        turma.setTamanhoTurma(listaAluno.size());

        int reprovado = 0;
        int aprovado = 0;

        double media = 0;

        double maior = 0;
        double menor = 11.0;

        for (Aluno aluno : listaAluno) {
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

        turma.setAprovado(aprovado);
        turma.setReprovado(reprovado);
        turma.setMenor(menor);
        turma.setMaior(maior);
        turma.setMedia(mediaFinal);

    }

    public boolean gravar(){
        return gravador.gravar(turma);
    }


}
