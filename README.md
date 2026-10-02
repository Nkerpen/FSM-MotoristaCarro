Máquina de Estados - Simulação Motorista e Carro

Este projeto é uma implementação do padrão de projeto State em Java, desenvolvido para a disciplina de Inteligência Artificial e Ilusão de Inteligência em Jogos (PUCPR).

O projeto simula a interação entre dois agentes: um Motorista (Agente A) e um Carro (Agente B). Existe comunicação direta entre os agentes, onde as ações do motorista ditam os estados do carro, e as condições do carro (combustível e sujeira) forçam a troca de estados do motorista.

 Agentes e Estados

Agente A (Motorista)

Dirigindo: Estado principal. O motorista faz o carro andar.

Abastecendo: O motorista para o carro para encher o tanque.

Lavando: O motorista para o carro para limpá-lo.

Agente B (Carro)

Andando: O carro está em movimento, consumindo combustível (-20/tick) e gerando sujeira (+10/tick).

Parado: O carro está inativo aguardando as ações do motorista.

 Como compilar e rodar

Como o projeto utiliza apenas Java padrão, sem bibliotecas externas, a execução é bastante simples:

Clone este repositório na sua máquina local.

Abra o projeto na sua IDE de preferência (recomendado: IntelliJ IDEA).

Certifique-se de que a pasta src está marcada como a raiz dos códigos-fonte (Sources Root).

Navegue até o arquivo Main.java localizado em src/Main.java.

Execute a classe Main clicando no botão de "Run" da sua IDE.

 Como observar as transições nos logs

A simulação está configurada para rodar um loop de exatos 30 ticks, com intervalo de 1 segundo entre eles.
Para observar as transições:

Abra o painel do Console/Terminal na sua IDE após iniciar o programa.

Observe os avisos de [Entrou no estado...] e [Saiu do estado...] que indicam claramente as trocas de estado de cada agente.

Acompanhe a impressão dos níveis de Combustível e Sujeira a cada tick para entender o gatilho exato que causou a transição do motorista (ex: Combustível <= 0 ou Sujeira >= 100).

 Estrutura de Pastas

/src: Contém todo o código-fonte Java estruturado com o padrão State.

/docs: Contém o documento final em PDF e as imagens dos diagramas de estado elaborados.
