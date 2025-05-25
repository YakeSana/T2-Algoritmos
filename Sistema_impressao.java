import java.io.File;

public class Sistema_impressao {
    private Fila fila = new Fila(4);
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void imprimirProximo(){
        if(!fila.filaVazia()){
            Registro impresso = fila.desenfileira();
            impresso.setHorario_impressao();
            System.out.println("O arquivo "+ impresso.getNomeArquivo()+ " foi impresso com tempo de espera de "+impresso.getTempodeEspera()+".");
        }
    }

    public void adicionarArquivo(File arquivo){
        if(!fila.filaCheia()){
            fila.enfileira(new Registro(arquivo, usuario));
        }
        else System.out.println("Fila de impressão cheia, tente novamente mais tarde.\n");
    }

    public void exibirFiladeImpressao(){
        System.out.println("Registro da Fila de Impressão: ");
        System.out.println(fila);
    }

}
