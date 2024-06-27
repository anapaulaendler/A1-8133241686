package br.edu.up.modelos;

import java.util.ArrayList;

public class Turma {
    
    ArrayList<Aluno> listaAlunos;
    int tamanhoTurma;
    int aprovado;
    int reprovado;
    double menor;
    double maior;
    double media;
    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
    public int getTamanhoTurma() {
        return tamanhoTurma;
    }
    public void setTamanhoTurma(int tamanhoTurma) {
        this.tamanhoTurma = tamanhoTurma;
    }
    public int getAprovado() {
        return aprovado;
    }
    public void setAprovado(int aprovado) {
        this.aprovado = aprovado;
    }
    public int getReprovado() {
        return reprovado;
    }
    public void setReprovado(int reprovado) {
        this.reprovado = reprovado;
    }
    public double getMenor() {
        return menor;
    }
    public void setMenor(double menor) {
        this.menor = menor;
    }
    public double getMaior() {
        return maior;
    }
    public void setMaior(double maior) {
        this.maior = maior;
    }
    public double getMedia() {
        return media;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public Turma(ArrayList<Aluno> listaAlunos, int tamanhoTurma, int aprovado, int reprovado, double menor,
            double maior, double media) {
        this.listaAlunos = listaAlunos;
        this.tamanhoTurma = tamanhoTurma;
        this.aprovado = aprovado;
        this.reprovado = reprovado;
        this.menor = menor;
        this.maior = maior;
        this.media = media;
    }
    public Turma() {
    }
    public String toCSV() {
        return tamanhoTurma + ";" + aprovado
                + ";" + reprovado + ";" + menor + ";" + maior + ";" + media;
    }

    
}
