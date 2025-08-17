public class PersonagemGame {

    private String nome;
    private int saudeAtual;
    private String status;


    public PersonagemGame(int saudeAtualInicial, String nomeInicial) {
        setNome(nomeInicial);
        setSaudeAtual(saudeAtualInicial);
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) saudeAtual = 0;
        if (saudeAtual > 100) saudeAtual = 100;
        this.saudeAtual = saudeAtual;
        atualizarStatus();
    }

    private void atualizarStatus() {
        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public void receberCura(int quantidadeDeCura) {
        if (quantidadeDeCura < 0) return;
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }

    public void tomarDano(int quantidadeDeDano) {
        if (quantidadeDeDano < 0) return;
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }
}
