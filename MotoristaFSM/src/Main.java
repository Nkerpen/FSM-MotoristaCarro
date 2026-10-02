public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Motorista motorista = new Motorista(carro);

        // Define o estado inicial da simulação
        motorista.setEstado(new DirigindoState(motorista, carro));

        // O laço for executará exatamente 30 vezes
        for (int tick = 1; tick <= 30; tick++) {
            System.out.println("--- TICK " + tick + " ---");

            motorista.tick();
            carro.tick();

            System.out.println("-------------------------");

            try {
                Thread.sleep(1000); // Pausa de 1 segundo entre os ticks
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Simulação finalizada após 30 ticks.");
    }
}