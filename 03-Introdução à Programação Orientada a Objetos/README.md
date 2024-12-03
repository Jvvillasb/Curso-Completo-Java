### 03-Introdução à Programação Orientada a Objetos

## 1.Introdução à Orientação a Objetos (OO)

- A Orientação a Objetos (OO) é um paradigma de programação que organiza o código em objetos, representando entidades do mundo real.

### Princípios Fundamentais:

- **Abstração**: Foco nas características essenciais, ignorando detalhes irrelevantes.
- **Encapsulamento**: Controle de acesso às informações, protegendo os dados.
- **Herança**: Reutilização de código através de classes derivadas.
- **Polimorfismo**: Objetos de diferentes tipos podem ser tratados de forma uniforme.

## 2.Classes e Objetos

### Classes: É um modelo ou molde que define atributos (dados) e métodos (comportamentos).

### Objeto: É uma instância de uma classe, representando uma entidade específica.

```java
class Pessoa {
    String nome;
    int idade;

    void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "João";
        pessoa.idade = 23;
        pessoa.apresentar();
    }
}
```

## 3. Construtores e Métodos

### Construtores: São métodos especiais usados para inicializar objetos.

### Métodos: Definem os comportamentos dos objetos.

```java
class Pessoa {
    String nome;
    int idade;

    // Construtor
    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método
    void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}
```

## 4. Encapsulamento e Modificadores de Acesso

### Encapsulamento: Permite proteger os dados de acesso indevido.

### Modificadores de Acesso: 

- **private**: Visível apenas na própria classe.
- **protected**: Visível na classe e subclasses.
- **public**: Visível globalmente.

```java
class Conta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}
```

## 5. Herança

### Herança: Permite que uma classe herde atributos e métodos de outra.

```java
class Animal {
    void comer() {
        System.out.println("Comendo...");
    }
}

class Cachorro extends Animal {
    void latir() {
        System.out.println("Au au!");
    }
}
```

## 6.Polimorfismo

### Polimorfismo: Permite que métodos com o mesmo nome tenham diferentes implementações.sssssssssss

```java
class Animal {
    void emitirSom() {
        System.out.println("Som genérico");
    }
}

class Gato extends Animal
```