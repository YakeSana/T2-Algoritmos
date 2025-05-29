public class TesteFilaImpressao {
    public static void main(String[] args) {
        FilaImpressao filaImpressao = new FilaImpressao(5); 

        filaImpressao.adicionarDocumento("relatorio_vendas.pdf", "Ana Silva");
        filaImpressao.adicionarDocumento("apresentacao_novo_projeto.pptx", "João Pereira");
        filaImpressao.adicionarDocumento("contrato_cliente_x.docx", "Maria Santos");

        esperar(2000);

        filaImpressao.statusFila();

        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();

        filaImpressao.statusFila();

        esperar(2000);
        
        filaImpressao.adicionarDocumento("nota_fiscal_123.txt", "Carlos Souza");
        filaImpressao.adicionarDocumento("proposta_final.pdf", "Ana Silva");
        filaImpressao.adicionarDocumento("imagem_logo.png", "Pedro Rocha"); 

        filaImpressao.statusFila();

        filaImpressao.consultarDocumento("contrato_cliente_x.docx");
        filaImpressao.consultarDocumento("documento_inexistente.pdf");

        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento(); 

        filaImpressao.statusFila();
        filaImpressao.relatorioImpressoes();
    }

    private static void esperar(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}