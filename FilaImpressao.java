import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;


class FilaImpressao {
    private Fila fila;
    private int capacidadeMaxima;
    private List<Documento> documentosImpressos;

    public FilaImpressao(int capacidadeMaxima) {
        this.fila = new Fila(capacidadeMaxima);
        this.capacidadeMaxima = capacidadeMaxima;
        this.documentosImpressos = new ArrayList<>();
    }

    public boolean adicionarDocumento(String nomeArquivo, String nomeUsuario) {
        if (!fila.filaCheia()) {
            Documento novoDocumento = new Documento(nomeArquivo, nomeUsuario);
            fila.enfileira(novoDocumento); 
            System.out.println("'" + novoDocumento.getNomeArquivo() + "' adicionado à fila.");
            return true;
        } else {
            System.out.println("Erro: Fila de impressão cheia. Não é possível adicionar novos documentos.");
            return false;
        }
    }

    public Documento imprimirDocumento() {
        if (!fila.filaVazia()) {
            Documento documentoAImprimir = fila.desenfileira(); 
            documentoAImprimir.setHoraImpressao(LocalDateTime.now());
            documentoAImprimir.setTempoEspera(Duration.between(documentoAImprimir.getHoraSolicitacao(),
                    documentoAImprimir.getHoraImpressao()));
            documentosImpressos.add(documentoAImprimir); 
            System.out.println("Imprimindo: '" + documentoAImprimir.getNomeArquivo() + "'.");
            System.out.printf("Tempo de espera: %.2f segundos.%n", documentoAImprimir.getTempoEspera().toMillis() / 1000.0);
            return documentoAImprimir;
        } else {
            System.out.println("Fila de impressão vazia. Nenhum documento para imprimir.");
            return null;
        }
    }

    public Documento consultarDocumento(String nomeArquivo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Documento doc = fila.buscaDocumento(nomeArquivo);
        if (doc!=null) {
            System.out.println("Documento '" + nomeArquivo + "' encontrado na fila.");
            System.out.println("Hora de solicitação: " + doc.getHoraSolicitacao().format(formatter));
            return doc;
        }
        System.out.println("Documento '" + nomeArquivo + "' não encontrado na fila.");
        return null;
    }

    public void statusFila() {
        System.out.println("\n--- Status Atual da Fila de Impressão ---");
        if (fila.filaVazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println(fila);
        }
        System.out.println("Documentos na fila: " + fila.getOcupacao() + "/" + capacidadeMaxima);
        System.out.println("---------------------------------------");
    }

    public void relatorioImpressoes() {
        System.out.println("\n--- Relatório de Documentos Impressos ---");
        if (documentosImpressos.isEmpty()) {
            System.out.println("Nenhum documento foi impresso ainda.");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            for (Documento doc : documentosImpressos) {
                System.out.println("Arquivo: " + doc.getNomeArquivo() + ", Usuário: " + doc.getNomeUsuario());
                System.out.printf("  Solicitação: %s, Impressão: %s, Espera: %.2fs%n",
                        doc.getHoraSolicitacao().format(formatter),
                        doc.getHoraImpressao().format(formatter),
                        doc.getTempoEspera().toMillis() / 1000.0);
            }
        }
        System.out.println("---------------------------------------");
    }
}