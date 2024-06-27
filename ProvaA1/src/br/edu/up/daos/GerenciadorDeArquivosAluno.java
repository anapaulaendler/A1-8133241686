    package br.edu.up.daos;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.ArrayList;
    import java.util.Scanner;

import br.edu.up.modelos.Aluno;

    public class GerenciadorDeArquivosAluno {
    
        public String header = "Matricula;Nome;Nota";
        public String nomeDoArquivo;

        public GerenciadorDeArquivosAluno() {
            Path caminhoArquivo = Paths.get("src", "br", "edu", "up", "csv", "alunos.csv");
            nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
        }

        public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> listaAluno = new ArrayList<>();

        try {
            File arquivo = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivo);

            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linhaAtual = leitor.nextLine();
                String[] dados = linhaAtual.split(";");

                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double nota = Double.parseDouble(dados[2]);

                Aluno aluno = new Aluno(matricula, nome, nota);
                listaAluno.add(aluno);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'Alunos' não foi encontrado");
        }
    return listaAluno;
    }
}
