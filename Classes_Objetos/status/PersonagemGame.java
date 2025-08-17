public class PersonagemGame {
    private String nome;
    private int saudeAtual;
    private String status;

    public PersonagemGame() {
        this.saudeAtual = 100;
        atualizarStatus();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public String getStatus() {
        return status;
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
        if (quantidadeDeCura <= 0) return;
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }

    public void tomarDano(int quantidadeDeDano) {
        if (quantidadeDeDano <= 0) return;
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

}
