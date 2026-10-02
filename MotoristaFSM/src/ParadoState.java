public class ParadoState implements State {
    private Carro carro;

    public ParadoState(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void enter() {
        System.out.println("----O carro Entrou no estado [Parado]----");
    }

    @Override
    public void execute() {
        System.out.println("Carro: ...estacionado e desligado...");
        // Enquanto está parado, o carro por si só não consome combustível nem gera sujeira.
    }

    @Override
    public void leave() {
        System.out.println("----O carro Saiu do estado [Parado]----");
    }
}