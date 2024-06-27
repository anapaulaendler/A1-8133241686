import br.edu.up.controles.Controle;

public class Programa {
    public static void main(String[] args) throws Exception {
        Controle controleAluno = new Controle();

        controleAluno.lerAlunos();
        controleAluno.calcular();
        controleAluno.gravar();
    }
}
