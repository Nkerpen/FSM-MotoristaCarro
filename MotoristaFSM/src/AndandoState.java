public class AndandoState implements State {
    private Carro carro;

    public AndandoState(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void enter() {
        System.out.println("---- O carro entrou no estado [Andando]----");
    }

    @Override
    public void execute() {
        System.out.println("Carro: ...em movimento pela rua...");

        // Diminui 20 de combustível e aumenta 10 de sujeira por tick
        carro.setCombustivel(carro.getCombustivel() - 20);
        carro.setSujeira(carro.getSujeira() + 10);

        System.out.println("   -> Níveis Atuais do Carro | Combustível: " + carro.getCombustivel() + " | Sujeira: " + carro.getSujeira());
    }

    @Override
    public void leave() {
        System.out.println("----O carro Saiu do estado [Andando]----");
    }
}