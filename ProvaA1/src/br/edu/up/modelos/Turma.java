package br.edu.up.modelos;

import java.util.ArrayList;

public class Turma {
    
    private ArrayList<Aluno> listaAlunos;
    private int tamanhoTurma;
    private int aprovado;
    private int reprovado;
    private double menor;
    private double maior;
    private double media;

    // Getters e setters
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

    // Construtor completo
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

    // Construtor sem a lista de alunos
    public Turma(int tamanhoTurma, int aprovado, int reprovado, double menor, double maior, double media) {
        this.tamanhoTurma = tamanhoTurma;
        this.aprovado = aprovado;
        this.reprovado = reprovado;
        this.menor = menor;
        this.maior = maior;
        this.media = media;
    }

    // Construtor vazio
    public Turma() {
    }

    // Método para retornar os dados em formato CSV
    public String toCSV() {
        return tamanhoTurma + ";" + aprovado + ";" + reprovado + ";" + menor + ";" + maior + ";" + media;
    }
}

