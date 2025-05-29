public class TestePilhaReimpressao {
    public static void main(String[] args) {
        PilhaReimpressao pilha = new PilhaReimpressao(5);

        pilha.solicitarReimpressao("relatorio_final.pdf", "João Silva");
        pilha.solicitarReimpressao("apresentacao.pptx", "Maria Souza");
        pilha.solicitarReimpressao("contrato.docx", "Carlos Oliveira");
        
        esperar(2000);

        pilha.consultarDocumento("apresentacao.pptx");


        pilha.gerarRelatorio();

        esperar(2000);

        pilha.imprimir();

        pilha.gerarRelatorio();

        pilha.solicitarReimpressao("doc1.pdf", "Ana");
        pilha.solicitarReimpressao("doc2.pdf", "Pedro");
        pilha.solicitarReimpressao("doc3.pdf", "Lucia");
        pilha.solicitarReimpressao("doc4.pdf", "Marcos");

        pilha.gerarRelatorio();
    }

    private static void esperar(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
