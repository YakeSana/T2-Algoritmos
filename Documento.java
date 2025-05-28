import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private LocalDateTime horaSolicitacao;
    private LocalDateTime horaImpressao;
    private LocalDateTime horarioReimpressao;
    private Duration tempoEspera;

    public Documento(String nomeArquivo, String nomeUsuario) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horaSolicitacao = LocalDateTime.now();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDateTime getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public LocalDateTime getHoraImpressao() {
        return horaImpressao;
    }

    public Duration getTempoEspera() {
        return tempoEspera;
    }

    public void setHoraImpressao(LocalDateTime horaImpressao) {
        this.horaImpressao = horaImpressao;
    }

    public void setTempoEspera(Duration tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("Arquivo: %s, Usuário: %s, Solicitação: %s", nomeArquivo, nomeUsuario,
                horaSolicitacao.format(formatter));
    }

    public void setHorarioReimpressao() {
        this.horarioReimpressao = LocalDateTime.now();
    }

    public long getTempoEsperaReimpressao() {
        if (horarioReimpressao == null) setHorarioReimpressao();
        return Duration.between(horaSolicitacao, horarioReimpressao).toSeconds();
    }
}