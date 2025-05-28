public class PilhaVetor {
  private int topo;
  private Documento[] vetor;

  public PilhaVetor(int tamanho) {
    vetor = new Documento[tamanho];
    topo = 0;
  }

  public int getTopo() {
    return topo;
  }

  public PilhaVetor() {
    this(10);
  }

  public void push(Documento doc) {
    if (estaCheio())
      redimensiona(vetor.length * 2);
    vetor[topo++] = doc;
  }

  public int getTamanho() {
    return vetor.length;
  }
  
  public Documento pop() {
    if (estaVazio())
      throw new VetorVazioException("vetor vazio, nao ha o que remover");
    Documento aux = vetor[--topo];
    if (vetor.length >= 6 && topo <= vetor.length / 4)
      redimensiona(vetor.length / 2);
    return aux;
  }

  public boolean estaCheio() {
    return topo == vetor.length;
  }

  public boolean estaVazio() {
    return topo == 0;
  }

  private void redimensiona(int novoTamanho) {
    Documento[] temp = new Documento[novoTamanho];
    for (int i = 0; i < topo; i++) {
      temp[i] = vetor[i];
    }
    vetor = temp;
  }

  @Override
  public String toString() {
    String s = "-----------\n";
    if (estaVazio()) 
      s += "esta vazia\n";
    else 
      for (int i = topo-1; i >= 0; i--) {
        s += vetor[i] + "\n";
      }
    return s + "-----------\n";
  }

  public boolean contem(String nomeArquivo) {
    for (int j = 0; j < topo; j++)
      if (vetor[j].getNomeArquivo() == nomeArquivo)
        return true;
    return false;
  }

  public int indiceDe(String nomeArquivo) {
    for (int j = 0; j < topo; j++)
      if (vetor[j].getNomeArquivo() == nomeArquivo)
        return j;
    return -1;
  }

  public Documento consultaPorNome(String nomeArquivo) {
    for (int j = 0; j < topo; j++)
      if (vetor[j].getNomeArquivo() == nomeArquivo)
        return vetor[j];
    return null;
  }

  public Documento consultaPorIndice(int indice){
    return vetor[indice];
  }
}
class VetorVazioException extends RuntimeException {
  public VetorVazioException(String msg) {
    super(msg);
  }
}