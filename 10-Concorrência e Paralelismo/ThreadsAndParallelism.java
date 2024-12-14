import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadsAndParallelism  {
    public static void main(String[] args) {
        // Introdução a Threads e Concorrência
        Thread thread1 = new Thread(() -> System.out.println("Thread 1 em execução"));
        Thread thread2 = new Thread(() -> System.out.println("Thread 2 em execução"));
        thread1.start();
        thread2.start();

        // Sincronização e Controle de Acesso
        Contador contador = new Contador();
        Thread incrementador = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });
        Thread decrementador = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.decrementar();
            }
        });
        incrementador.start();
        decrementador.start();
        try {
            incrementador.join();
            decrementador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Valor final do contador: " + contador.getValor());

        // Executor Service e Future
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> resultado = executorService.submit(() -> {
            System.out.println("Executando tarefa no Executor Service");
            return 42;
        });
        try {
            System.out.println("Resultado da Future: " + resultado.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        // Paralelismo com ForkJoinPool e Parallel Streams
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> somaTask = forkJoinPool.submit(new SomaTask(0, 100));
        try {
            System.out.println("Resultado do ForkJoinPool: " + somaTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        forkJoinPool.shutdown();

        System.out.println("Parallel Stream Resultado: " + IntStream.range(1, 10).parallel().sum());
    }

    static class Contador {
        private int valor = 0;

        public synchronized void incrementar() {
            valor++;
        }

        public synchronized void decrementar() {
            valor--;
        }

        public synchronized int getValor() {
            return valor;
        }
    }

    static class SomaTask extends RecursiveTask<Integer> {
        private final int inicio;
        private final int fim;
        private static final int LIMITE = 10;

        public SomaTask(int inicio, int fim) {
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        protected Integer compute() {
            if ((fim - inicio) <= LIMITE) {
                int soma = 0;
                for (int i = inicio; i < fim; i++) {
                    soma += i;
                }
                return soma;
            } else {
                int meio = (inicio + fim) / 2;
                SomaTask tarefa1 = new SomaTask(inicio, meio);
                SomaTask tarefa2 = new SomaTask(meio, fim);
                invokeAll(tarefa1, tarefa2);
                return tarefa1.join() + tarefa2.join();
            }
        }
    }
}
