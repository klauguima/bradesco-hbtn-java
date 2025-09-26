import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        this.canais.add(canal);
    }

    public void processar(Video video) {
        // mensagem "<arquivo> - <formato>" do tipo LOG
        String texto = video.getArquivo() + " - " + video.getFormato();
        Mensagem mensagem = new Mensagem(texto, TipoMensagem.LOG);

        for (CanalNotificacao canal : canais) {
            canal.notificar(mensagem);
        }
    }
}
