
// ===== Introdução à Orientação a Objetos =====
class Pessoa {
    private String nome;
    private int idade;

    // ===== Construtores =====
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // ===== Encapsulamento e Modificadores de Acesso =====
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}

// ===== Herança e Polimorfismo =====
class Animal {
    void emitirSom() {
        System.out.println("Som genérico.");
    }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Au au!");
    }
}

// ===== Interfaces =====
interface Trabalhador {
    void trabalhar();
}

// ===== Implementação de Interfaces =====
class Engenheiro implements Trabalhador {
    public void trabalhar() {
        System.out.println("Projetando edifícios...");
    }
}

// ===== Classes Abstratas =====
abstract class Forma {
    abstract double calcularArea();
}

class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    double calcularArea() {
        return Math.PI * raio * raio;
    }
}

public class Main {
    public static void main(String[] args) {
        // ===== Exemplo de Classes e Objetos =====
        Pessoa pessoa = new Pessoa("João", 23);
        pessoa.apresentar();

        // ===== Exemplo de Herança e Polimorfismo =====
        Animal meuCachorro = new Cachorro();
        meuCachorro.emitirSom();

        // ===== Exemplo de Interfaces =====
        Trabalhador engenheiro = new Engenheiro();
        engenheiro.trabalhar();

        // ===== Exemplo de Classes Abstratas =====
        Forma circulo = new Circulo(5);
        System.out.println("Área do círculo: " + circulo.calcularArea());
    }
}
