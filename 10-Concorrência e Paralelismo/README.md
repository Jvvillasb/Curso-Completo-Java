### 10-Concorrência e Paralelismo em Java

- ***OBS:*** Não Tem trecho de código nesse Exemplo, mas todas referências são do Arquivo **ThreadsAndParallelism.java** desse módulo

## 1. Introdução a Threads e Concorrência

- **Definição**: Threads são unidades leves de execução que permitem realizar tarefas em paralelo dentro de um programa. O modelo de concorrência em Java permite executar várias threads ao mesmo tempo.
- **Uso**:  Pode-se criar threads usando a classe **Thread** ou implementando a interface **Runnable**.
- **Vantagens**: Melhor utilização dos recursos do sistema e maior desempenho em tarefas independentes.
- **Exemplo**: O código cria e executa duas threads (**thread1** e **thread2**) que imprimem mensagens paralelamente.

## 2. Sincronização e Controle de Acesso

- **Definição**: Em ambientes multithreaded, o acesso simultâneo a recursos compartilhados pode causar inconsistências. A sincronização controla o acesso para evitar problemas como race conditions.
- **Uso**:  A palavra-chave **synchronized** é usada para proteger métodos ou blocos críticos.
- **Exemplo**: A classe **Contador** protege os métodos de incremento e decremento com **synchronized** para evitar problemas de concorrência.

## 3. Executor Service e Future

- **Definição**: **ExecutorService** fornece uma abstração para criar e gerenciar pools de threads, enquanto **Future** representa o resultado de uma tarefa assíncrona.
- **Uso**: Tarefas são enviadas para o **ExecutorService** e retornam objetos **Future** que permitem obter o resultado ou verificar o status da execução.
- **Vantagens**: Simplifica o gerenciamento de threads e permite realizar tarefas assíncronas com facilidade.
- **Exemplo**: O código demonstra a execução de uma tarefa que retorna o número 42 de forma assíncrona.

## 4. Concorrência Avançada (ForkJoinPool)

- **Definição**: **ForkJoinPool** é um framework para dividir tarefas grandes em subtarefas menores que podem ser executadas paralelamente. Ele é baseado no padrão divide-and-conquer.
- **Uso**: Classes como **RecursiveTask e RecursiveAction** permitem implementar tarefas que podem ser divididas recursivamente.
- **Exemplo**:A classe **SomaTask** calcula a soma de um intervalo de números dividindo-o em partes menores, aproveitando o processamento paralelo.

## 5. Paralelismo com Streams Paralelos

- **Definição**: Streams paralelos (**parallelStream**) facilitam a execução de operações em coleções em paralelo. Eles utilizam internamente o **ForkJoinPool**.
- **Uso**: É uma abordagem declarativa para paralelizar operações como mapeamento, filtragem e redução.
- **Vantagens**: Simplifica o paralelismo para operações em coleções, aproveitando múltiplos núcleos do processador.
- **Exemplo**:O código usa um **IntStream** paralelo para calcular a soma dos números de 1 a 9.
