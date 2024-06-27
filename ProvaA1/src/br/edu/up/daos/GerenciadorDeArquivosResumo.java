package br.edu.up.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.edu.up.modelos.Turma;

public class GerenciadorDeArquivosResumo {
    private String header = "qtdeAlunos;qtdeAprovados;qtdeReprovados;menorNota;maiorNota;mediaGeral";
    private String nomeDoArquivo;

    public GerenciadorDeArquivosResumo() {
        Path caminhoArquivo = Paths.get("src", "br", "edu", "up", "csv", "resumo.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public boolean gravar(ArrayList<Turma> listaTurma) {
        try {
            Files.createDirectories(Paths.get("src", "br", "edu", "up", "csv"));
        } catch (IOException e) {
            System.err.println("Não foi possível criar os diretórios necessários: " + e.getMessage());
            return false;
        }

        try (FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
             PrintWriter gravador = new PrintWriter(arquivoGravar)) {

            gravador.println(header);

            for (Turma turma : listaTurma) {
                gravador.println(turma.toCSV());
            }

            return true;
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
        return false;
    }
}
