public class Fila {
    private Documento[] dados;
    private int primeiro, ultimo, ocupacao;
    public Fila (int capacidade) {
        dados = new Documento[capacidade];
        //por clareza
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }
    public Fila () {
        this(10);
    }
    public boolean filaVazia() {
        return ocupacao == 0;
    }
    public boolean filaCheia() {
        return ocupacao == dados.length;
    }
    private int proxima (int pos) {
        return (pos + 1) % dados.length;
    }
    public void enfileira (Documento doc) {
        if (filaCheia()) throw new RuntimeException("falha no enfileiramento");
        dados[ultimo] = doc;
        ultimo = proxima(ultimo);
        ocupacao++;
    }
    public Documento desenfileira () {
        if (filaVazia()) throw new RuntimeException("falha no desenfileiramento");
        Documento temp = dados[primeiro];
        primeiro = proxima(primeiro);
        ocupacao--;
        return temp;
    }
    @Override
    public String toString () {
        if (filaVazia()) return "Fila vazia";
        String s = "";
        for (int i=primeiro, cont=0; cont < ocupacao; cont++) {
            s += dados[i] + "\n ";
            i = proxima(i);
        }
        return s;
    }
    public String stringVetor() {
        String s="";
        int i;
        if (filaVazia())
            for (i=0; i<dados.length; i++)
                s += "_ ";
        else if (filaCheia())
            for(i=0; i<dados.length; i++)
                s += dados[i] + " ";
        else if (primeiro < ultimo) {
            for (i=0; i < primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo; i<dados.length; i++)
                s += "_ ";
        }
        else {
            for (i=0; i < ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo; i<primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<dados.length; i++)
                s += dados[i] + " ";
        }
        return s;
    }

    public int getOcupacao() {
        return ocupacao;
    }
    public boolean estaNaFila(String arquivo) {
        for (int i=primeiro, cont=0; cont < ocupacao; cont++) {
            if (dados[i].getNomeArquivo() == arquivo) return true;
            i = proxima(i);
        }
        return false;
    }

    public Documento buscaDocumento(String arquivo) {
        for (int i=primeiro, cont=0; cont < ocupacao; cont++) {
            if (dados[i].getNomeArquivo() == arquivo) return dados[i];
            i = proxima(i);
        }
        return null;
    }
}