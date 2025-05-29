public class PilhaReimpressao {
    private PilhaVetor pilha;
    

    public PilhaReimpressao(int tamanho) {
        this.pilha = new PilhaVetor(tamanho);
    }

    public boolean solicitarReimpressao(String nomeArquivo, String nomeUsuario) {
        if (pilha.estaCheio()) {
            System.out.println("\nNão foi possível adicionar o documento, a pilha de impressão está cheia.");
            return false;
        }

        Documento doc = new Documento(nomeArquivo, nomeUsuario);
        pilha.push(doc);
        System.out.println("\nDocumento '" + nomeArquivo + "' adicionado à pilha de impressão.");
        return true;
    }

    public void imprimir() {
        if (pilha.estaVazio()) {
            System.out.println("\nNão há nenhum documento na pilha de impressão.");
            return;
        }

        Documento doc = pilha.pop();
        doc.setHorarioAtual();
        long tempoEspera = doc.getTempoEsperaReimpressao();

        System.out.println("\nReimprimindo documento: " + doc.getNomeArquivo());
        System.out.println("Solicitado por: " + doc.getNomeUsuario());
        System.out.println("Tempo de espera: " + tempoEspera + " segundos");
    }

    public Documento consultarDocumento(String nomeArquivo) {
        if (pilha.estaVazio()) {
            System.out.println("\nO Documento não foi encontrado pois a pilha de impressão está vazia.");
            return null;
        }

        if (pilha.contem(nomeArquivo)) {
            Documento doc = pilha.consultaPorNome(nomeArquivo);
            System.out.println("\n"+doc.getNomeArquivo() + " foi encontrado na posição " + pilha.indiceDe(nomeArquivo) + " a partir do topo.");
            System.out.println("Solicitado por: " + doc.getNomeUsuario());
            System.out.println("Horário da solicitação: " + doc.getHoraSolicitacao());
            System.out.println("Tempo na fila: " + doc.getTempoEsperaReimpressao() + " segundos");
            return doc;
        }

        System.out.println("\nDocumento '" + nomeArquivo + "' não encontrado na pilha de impressão.");
        return null;
    }

    
    public void gerarRelatorio() {
        if (pilha.estaVazio()) {
            System.out.println("\nNão foi possível gerar o relatório pois a pilha de impressão está vazia.");
            return;
        }

        System.out.println("\n=== RELATÓRIO DA PILHA DE REIMPRESSÃO ===");
        System.out.println("Documentos na pilha: " + pilha.getTopo() + "/" + pilha.getTamanho());
        System.out.println("Ordem (do topo para a base):\n");

        int posicao = 1;
        
        for (int i = pilha.getTopo() - 1; i >= 0; i--) {
            Documento doc = pilha.consultaPorIndice(i);
            System.out.println(posicao + ". " + doc.getNomeArquivo());
            System.out.println("   Usuário: " + doc.getNomeUsuario());
            System.out.println("   Horário solicitação: " + doc.getHoraSolicitacao());
            System.out.println("   Tempo na fila: " + doc.getTempoEsperaReimpressao() + " segundos");
            System.out.println("----------------------------------");
            posicao++;
        }
    }
}