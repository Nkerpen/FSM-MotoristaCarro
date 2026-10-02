// Motorista.java
public class Motorista {
    private State estadoAtual;
    private Carro carro;

    public Motorista(Carro carro) {
        this.carro = carro;
    }

    public void setEstado(State novoEstado) {
        if (this.estadoAtual != null) this.estadoAtual.leave();
        this.estadoAtual = novoEstado;
        this.estadoAtual.enter();
    }

    public void tick() {
        if (estadoAtual != null) estadoAtual.execute();
    }
}