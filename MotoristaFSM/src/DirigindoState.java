// DirigindoState.java
public class DirigindoState implements State {
    private Motorista motorista;
    private Carro carro;

    public DirigindoState(Motorista motorista, Carro carro) {
        this.motorista = motorista;
        this.carro = carro;
    }

    @Override
    public void enter() {
        System.out.println("----Entrou no estado [Dirigindo]----");
        System.out.println("Motorista: De volta a estrada...");

        // Comunicação entre agentes garante que o carro ande
        carro.setEstado(new AndandoState(carro));
    }

    @Override
    public void execute() {
        System.out.println("Motorista: ...dirigindo atentamente...");

        // Verifica as variáveis do carro para transições
        if (carro.getCombustivel() <= 0) {
            motorista.setEstado(new AbastecendoState(motorista, carro));
        } else if (carro.getSujeira() >= 100) {
            motorista.setEstado(new LavandoState(motorista, carro));
        }
    }

    @Override
    public void leave() {
        System.out.println("----Saiu do estado [Dirigindo]----");
        System.out.println("Motorista: Mais uma parada...");

    }
}