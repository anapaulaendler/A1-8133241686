package br.edu.up.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.edu.up.modelos.*;

public class GerenciadorDeArquivosResumo {
    public String header = "qtdeAlunos;qtdeAprovados;qtdeReprovados;menorNota;maiorNota;mediaGeral";
    public String nomeDoArquivo;

    public GerenciadorDeArquivosResumo() {
        Path caminhoArquivo = Paths.get("src", "br", "edu", "up", "csv", "resumo.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public boolean gravar(Turma listaAlunos) {

        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);
            gravador.println(listaAlunos.toCSV());

            gravador.close();
            return true;
        } catch (IOException e) {
            System.out.println("Deu erro.");
        }
        return false;
    }
}
