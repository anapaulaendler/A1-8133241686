package br.edu.up.telas;

import java.util.Scanner;

import br.edu.up.controles.Controle;

public class Menu {
    
    Controle controle = new Controle();
    Scanner leitor = new Scanner(System.in);

    public void executar() {
        System.out.println("Bem-vindo ao menu! Digite 1 para realizar o processo e 0 para sair!");
        int n = 0;

        do {
            n = leitor.nextInt();

            switch (n) {
                case 1:
                    controle.fundirAlunosTurma();
                    break;
            
                default:
                    break;
            }
        } while (n != 0);
    }
}
