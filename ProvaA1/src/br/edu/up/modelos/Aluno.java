package br.edu.up.modelos;

public class Aluno {
    
    int matricula;
    String nome;
    double nota;

    public Aluno() {
    }
    public Aluno(int matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + ", nota=" + nota + "]";
    }

    public String toCSV() {
        return matricula + ";" + nome + ";" + nota;
    }
}
