import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private File arquivo;
    private String usuario;
    private LocalDateTime horario;
    private LocalDateTime horario_impressao;
    private Duration tempo_de_espera;

    public Registro(File arquivo, String usuario) {
        this.arquivo = arquivo;
        this.usuario = usuario;
        horario = LocalDateTime.now();
    }

    @Override
    public String toString(){
        if(horario_impressao == null) return "O arquivo "+ arquivo.getName()+ " foi adicionado para impressão pelo usuário "+usuario +" no dia "+ formataHorario(horario,"dd/MM/yyyy")+" as " + formataHorario(horario,"HH:mm")+" horas.";
        else return "O arquivo "+ arquivo.getName()+ " foi adicionado para impressão pelo usuário "+usuario +" no dia "+ formataHorario(horario,"dd/MM/yyyy")+" as " + formataHorario(horario,"HH:mm")+" horas e foi impresso no dia "+formataHorario(horario_impressao,"dd/MM/yyyy" )+" as " + formataHorario(horario_impressao,"HH:mm")+" horas." ;
    }

    private String formataHorario(LocalDateTime hora, String formato){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern(formato);
        return hora.format(formatador);
    }

    public String getNomeArquivo() {
        return arquivo.getName();
    }

    public void setHorario_impressao() {
        horario_impressao = LocalDateTime.now();
    }
    
    public String getTempodeEspera(){
        if(horario_impressao != null){
            tempo_de_espera = Duration.between(horario,horario_impressao);
            return tempo_de_espera.toHours()+" horas e " + (tempo_de_espera.toMinutes() % 60) +" minutos.";
        }
        return "0";
    }    
}
