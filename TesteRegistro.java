import java.io.File;

public class TesteRegistro {
    public static void main(String[] args) {
        // Registro registro = new Registro(new File("arquivo.txt"), "Miguel");
        // System.out.println(registro.toString());
        Sistema_impressao sistema = new Sistema_impressao();
        sistema.setUsuario("Guel");
        sistema.adicionarArquivo(new File("arquivo.txt"));
        sistema.adicionarArquivo(new File("a4.txt"));
        sistema.exibirFiladeImpressao();
        sistema.imprimirProximo();
        sistema.exibirFiladeImpressao();
    }
}
