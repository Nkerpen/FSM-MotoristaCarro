public class AbastecendoState implements State {
    private Motorista motorista;
    private Carro carro;

    public AbastecendoState(Motorista motorista, Carro carro) {
        this.motorista = motorista;
        this.carro = carro;
    }

    @Override
    public void enter() {
        System.out.println("----Entrou no estado [Abastecendo]----");
        System.out.println("Motorista: Hora de encher o tanque...");

        // Força a comunicação: O carro obrigatoriamente fica Parado.
        carro.setEstado(new ParadoState(carro));
    }

    @Override
    public void execute() {
        System.out.println("Motorista: Reabastecendo... Sujei um pouco o carro. ");

        // Aumenta combustível em +50 e sujeira em +5 por tick
        carro.setCombustivel(carro.getCombustivel() + 50);
        carro.setSujeira(carro.getSujeira() + 5);

        System.out.println("   -> Níveis Atuais | Combustível: " + carro.getCombustivel() + " | Sujeira: " + carro.getSujeira());

        // Regra de prioridade do seu jogo: Se a sujeira bater 100 durante o abastecimento,
        // ele tem que parar tudo e ir lavar.
        if (carro.getSujeira() >= 100) {
            motorista.setEstado(new LavandoState(motorista, carro));
            return; // Interrompe a execução atual
        }

        // Condição de saída: Se o tanque estiver cheio (100 ou mais), volta a dirigir.
        if (carro.getCombustivel() >= 100) {
            carro.setCombustivel(100); // Trava em 100 para não passar disso
            motorista.setEstado(new DirigindoState(motorista, carro));
        }
    }

    @Override
    public void leave() {
        System.out.println("---- Saiu do estado [Abastecendo] ----");
        System.out.println("Motorista: De volta a estrada.");

    }
}