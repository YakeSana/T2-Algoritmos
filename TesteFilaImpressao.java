public class TesteFilaImpressao {
    public static void main(String[] args) {
        FilaImpressao filaImpressao = new FilaImpressao(5); // Capacidade máxima de 5 documentos

        filaImpressao.adicionarDocumento("relatorio_vendas.pdf", "Ana Silva");
        filaImpressao.adicionarDocumento("apresentacao_novo_projeto.pptx", "João Pereira");
        filaImpressao.adicionarDocumento("contrato_cliente_x.docx", "Maria Santos");

        filaImpressao.statusFila();

        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();

        filaImpressao.statusFila();

        filaImpressao.adicionarDocumento("nota_fiscal_123.txt", "Carlos Souza");
        filaImpressao.adicionarDocumento("proposta_final.pdf", "Ana Silva");
        filaImpressao.adicionarDocumento("imagem_logo.png", "Pedro Rocha"); // Tenta adicionar, mas a fila está cheia

        filaImpressao.statusFila();

        filaImpressao.consultarDocumento("contrato_cliente_x.docx");
        filaImpressao.consultarDocumento("documento_inexistente.pdf");

        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento();
        filaImpressao.imprimirDocumento(); // Tenta imprimir, mas a fila está vazia

        filaImpressao.statusFila();
        filaImpressao.relatorioImpressoes();
    }
}