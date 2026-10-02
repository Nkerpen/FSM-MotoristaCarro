public class Carro {
    private State estadoAtual;
    private int combustivel = 100; // O carro começa com o tanque cheio
    private int sujeira = 0;       // O carro começa limpo

    public void setEstado(State novoEstado) {
        if (this.estadoAtual != null) this.estadoAtual.leave();
        this.estadoAtual = novoEstado;
        this.estadoAtual.enter();
    }

    public void tick() {
        if (estadoAtual != null) estadoAtual.execute();
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public int getSujeira() {
        return sujeira;
    }

    public void setSujeira(int sujeira) {
        this.sujeira = sujeira;
    }
}