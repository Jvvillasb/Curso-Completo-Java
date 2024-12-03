
// ===== Sobrecarga de Métodos e Construtores =====
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }

    double somar(double a, double b) {
        return a + b;
    }
}

// ===== Sobrescrita de Métodos =====
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

// ===== Composição e Agregação =====
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

// ===== Enum =====
enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}

// ===== Classes Aninhadas e Internas =====
class Externa {
    class Interna {
        void mostrarMensagem() {
            System.out.println("Olá da classe interna!");
        }
    }
}

// ===== Generics =====
class Caixa<T> {
    private T conteudo;

    void guardar(T conteudo) {
        this.conteudo = conteudo;
    }

    T abrir() {
        return conteudo;
    }
}

// ===== Record (Introdução ao Java 14+) =====
record Pessoa(String nome, int idade) {}

public class Main {
    public static void main(String[] args) {
        // Sobrecarga de Métodos
        Calculadora calc = new Calculadora();
        System.out.println("Soma de inteiros: " + calc.somar(3, 5));
        System.out.println("Soma de doubles: " + calc.somar(3.5, 2.5));

        // Sobrescrita de Métodos
        Animal meuGato = new Gato();
        meuGato.emitirSom();

        // Composição
        Carro carro = new Carro();
        carro.iniciar();

        // Enum
        DiaDaSemana hoje = DiaDaSemana.QUARTA;
        System.out.println("Hoje é: " + hoje);

        // Classes Internas
        Externa externa = new Externa();
        Externa.Interna interna = externa.new Interna();
        interna.mostrarMensagem();

        // Generics
        Caixa<String> caixa = new Caixa<>();
        caixa.guardar("Um objeto na caixa!");
        System.out.println("Conteúdo da caixa: " + caixa.abrir());

        // Record
        Pessoa pessoa = new Pessoa("João", 23);
        System.out.println("Pessoa: " + pessoa.nome() + ", Idade: " + pessoa.idade());
    }
}
