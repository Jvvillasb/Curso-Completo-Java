### 08-Programação Funcional com Java

## 1. Expressões Lambda

- As expressões lambda permitem criar funções anônimas concisas, eliminando a necessidade de classes anônimas para implementar interfaces funcionais.

```java
// Expressão Lambda simples
Runnable runnable = () -> System.out.println("Olá, Lambda!");
new Thread(runnable).start();

// Usando Lambda para somar dois números
interface Somador {
    int somar(int a, int b);
}

Somador somador = (a, b) -> a + b;
System.out.println("Resultado da soma: " + somador.somar(5, 3));
```

## 2. Interfaces Funcionais

- Uma interface funcional é aquela que possui apenas um método abstrato. Exemplos incluem **Runnable**, **Callable** e interfaces da API **java.util.function.**

```java
// Interface funcional personalizada
@FunctionalInterface
interface Calculador {
    int calcular(int x, int y);
}

// Usando a interface funcional com Lambda
Calculador multiplicador = (x, y) -> x * y;
System.out.println("Multiplicação: " + multiplicador.calcular(4, 5));
```
Interfaces funcionais comuns no Java:

- **Predicate<T>**: Retorna um booleano.
- **Function<T, R>**: Transforma um valor de tipo T em tipo R.
- **Consumer<T>**: Executa uma ação com um argumento T.


## 3. Stream API e Operações Funcionais (Map, Filter, Reduce)

- A API de Streams permite processar coleções de forma funcional e declarativa.

```java
import java.util.*;
import java.util.stream.*;

// Exemplo com map e filter
List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> nomesFiltrados = nomes.stream()
    .filter(nome -> nome.startsWith("A")) // Filtra nomes que começam com "A"
    .map(String::toUpperCase)            // Transforma em maiúsculas
    .collect(Collectors.toList());
System.out.println("Nomes filtrados: " + nomesFiltrados);

// Reduzindo uma lista de números para calcular a soma
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
int soma = numeros.stream()
    .reduce(0, Integer::sum);
System.out.println("Soma dos números: " + soma);
```

## 4. Manipulação e Transformação de Dados com Streams

- A manipulação com Streams é útil para transformar coleções em listas, mapas ou realizar operações complexas.

```java
// Convertendo uma lista de Strings para uma lista de inteiros
List<String> strings = Arrays.asList("1", "2", "3", "4");
List<Integer> inteiros = strings.stream()
    .map(Integer::valueOf) // Converte cada String para Integer
    .collect(Collectors.toList());
System.out.println("Inteiros: " + inteiros);

// Agrupando dados
List<String> items = Arrays.asList("banana", "maçã", "uva", "banana", "maçã");
Map<String, Long> contagem = items.stream()
    .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
System.out.println("Contagem de itens: " + contagem);
```

## 5. Programação Reativa (Introdução ao Flow API)

- A **Flow API** (introduzida no Java 9) implementa um modelo de programação reativa baseado no padrão Publisher-Subscriber. Ela é útil para lidar com fluxos de dados assíncronos.

```java
import java.util.concurrent.*;
import java.util.concurrent.Flow.*;

// Publisher simples
class SimplePublisher implements Publisher<String> {
    private final String[] data = {"Dado 1", "Dado 2", "Dado 3"};

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        for (String item : data) {
            subscriber.onNext(item); // Envia dados
        }
        subscriber.onComplete(); // Finaliza
    }
}

// Subscriber simples
class SimpleSubscriber implements Subscriber<String> {
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inscrito com sucesso!");
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

// Usando Flow API
SimplePublisher publisher = new SimplePublisher();
SimpleSubscriber subscriber = new SimpleSubscriber();
publisher.subscribe(subscriber);
```

