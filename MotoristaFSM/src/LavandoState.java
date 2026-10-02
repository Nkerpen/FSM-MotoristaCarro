public class LavandoState implements State {
    private Motorista motorista;
    private Carro carro;

    public LavandoState(Motorista motorista, Carro carro) {
        this.motorista = motorista;
        this.carro = carro;
    }

    @Override
    public void enter() {
        System.out.println("----Entrou no estado [Lavando]----");
        System.out.println("Motorista: Vou ter que te lavar...");

        // O carro também tem que estar parado enquanto é lavado.
        carro.setEstado(new ParadoState(carro));
    }

    @Override
    public void execute() {
        System.out.println("Motorista: ...esfregando a lataria do carro...");

        // Diminui a sujeira em -50 por tick
        carro.setSujeira(carro.getSujeira() - 50);

        System.out.println("   -> Níveis Atuais | Sujeira: " + carro.getSujeira());

        // Condição de saída: Quando a sujeira zerar (ou ficar negativa), o carro está limpo e volta a dirigir
        if (carro.getSujeira() <= 0) {
            carro.setSujeira(0); // Trava em 0 para não termos "sujeira negativa"
            motorista.setEstado(new DirigindoState(motorista, carro));
        }
    }

    @Override
    public void leave() {
        System.out.println("----Saiu do estado [Lavando]----");
        System.out.println("Motorista: De volta a estrada...");

    }
}