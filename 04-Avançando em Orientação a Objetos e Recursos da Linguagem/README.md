### 04-Avançando em Orientação a Objetos e Recursos da Linguagem

## 1. Sobrecarga de Métodos e Construtores

- Sobrecarga de Métodos.

### Sobrecarga de Métodos: Permite que uma classe tenha métodos com o mesmo nome, mas assinaturas diferentes.

### Sobrecarga de Construtores: Permite criar várias formas de inicializar objetos da mesma classe.

```java
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }

    double somar(double a, double b) {
        return a + b;
    }
}
```

### 2. Sobrescrita de Métodos

### Sobrescrita: Permite que uma subclasse forneça uma implementação específica para um método definido na classe pai.

```java
class Animal {
    void emitirSom() {
        System.out.println("Som genérico.");
    }
}

class Gato extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Miau!");
    }
}
```

## 3. Associações entre Objetos (Composição e Agregação)

### Composição: Relação onde um objeto depende fortemente de outro.

### Agregação: Relação onde objetos têm uma ligação, mas podem existir separadamente.

```java
class Motor {
    void ligar() {
        System.out.println("Motor ligado.");
    }
}

class Carro {
    private Motor motor = new Motor(); // Composição

    void iniciar() {
        motor.ligar();
    }
}
```

## 4. Introdução a Enums

### Enumeração (enum): Representa um conjunto fixo de constantes relacionadas.

```java
enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}
```

## 5. Classes Aninhadas e Internas

### Classes Aninhadas (Nested Classes): Definidas dentro de outra classe.

### Classes Internas: Têm acesso direto aos membros da classe externa.

```java
class Externa {
    class Interna {
        void mostrarMensagem() {
            System.out.println("Olá da classe interna!");
        }
    }
}
```

## 6. Generics

### Generics: Permite criar classes, interfaces e métodos que funcionem com qualquer tipo de dado.

```java
class Caixa<T> {
    private T conteudo;

    void guardar(T conteudo) {
        this.conteudo = conteudo;
    }

    T abrir() {
        return conteudo;
    }
}
```

## 7. Record (Introdução ao Java 14+)

### Record: Facilita a criação de classes imutáveis para transportar dados.

```java
record Pessoa(String nome, int idade) {}
```