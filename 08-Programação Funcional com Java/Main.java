import java.util.*;
import java.util.concurrent.Flow.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // 1. Expressões Lambda
        System.out.println("=== Expressões Lambda ===");
        Runnable runnable = () -> System.out.println("Olá, Lambda!");
        new Thread(runnable).start();

        Somador somador = (a, b) -> a + b;
        System.out.println("Soma usando Lambda: " + somador.somar(5, 3));

        // 2. Interfaces Funcionais
        System.out.println("\n=== Interfaces Funcionais ===");
        Calculador multiplicador = (x, y) -> x * y;
        System.out.println("Multiplicação: " + multiplicador.calcular(4, 5));

        Predicate<String> startsWithA = str -> str.startsWith("A");
        System.out.println("Começa com A? " + startsWithA.test("Alice"));

        // 3. Stream API e Operações Funcionais
        System.out.println("\n=== Stream API ===");
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> nomesFiltrados = nomes.stream()
                .filter(nome -> nome.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes filtrados: " + nomesFiltrados);

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        int soma = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println("Soma dos números: " + soma);

        // 4. Manipulação e Transformação de Dados
        System.out.println("\n=== Manipulação de Dados com Streams ===");
        List<String> strings = Arrays.asList("1", "2", "3", "4");
        List<Integer> inteiros = strings.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("Inteiros: " + inteiros);

        List<String> items = Arrays.asList("banana", "maçã", "uva", "banana", "maçã");
        Map<String, Long> contagem = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        System.out.println("Contagem de itens: " + contagem);

        // 5. Programação Reativa com Flow API
        System.out.println("\n=== Programação Reativa ===");
        SimplePublisher publisher = new SimplePublisher();
        SimpleSubscriber subscriber = new SimpleSubscriber();
        publisher.subscribe(subscriber);
    }

    // Interface funcional personalizada
    @FunctionalInterface
    interface Somador {
        int somar(int a, int b);
    }

    @FunctionalInterface
    interface Calculador {
        int calcular(int x, int y);
    }

    // Publisher simples
    static class SimplePublisher implements Publisher<String> {
        private final String[] data = {"Dado 1", "Dado 2", "Dado 3"};

        @Override
        public void subscribe(Subscriber<? super String> subscriber) {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    for (String item : data) {
                        subscriber.onNext(item);
                    }
                    subscriber.onComplete();
                }

                @Override
                public void cancel() {
                    System.out.println("Assinatura cancelada.");
                }
            });
        }
    }

    // Subscriber simples
    static class SimpleSubscriber implements Subscriber<String> {
        @Override
        public void onSubscribe(Subscription subscription) {
            System.out.println("Inscrito com sucesso!");
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println("Recebido: " + item);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Erro: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("Processamento completo.");
        }
    }
}
