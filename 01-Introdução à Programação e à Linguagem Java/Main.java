public class Main {
    public static void main(String[] args) {
        // Declaracao de variaveis
        int idade = 25;
        double altura = 1.75;
        boolean estudante = true;
        char genero = 'M';
        String nome = "Jo�o Silva";

        // Operadores aritmeticos
        int a = 10, b = 3;
        int soma = a + b;           // 13
        int subtracao = a - b;      // 7
        int multiplicacao = a * b;  // 30
        int divisao = a / b;        // 3
        int resto = a % b;          // 1

        // Operadores relacionais
        boolean comparacao1 = (a > b);   // true
        boolean comparacao2 = (a == b);  // false

        // Operadores logicos
        boolean logica1 = (a > 0 && b > 0);  // true
        boolean logica2 = (a > 10 || b > 0); // true

        // Impressao de resultados
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("� estudante? " + estudante);
    }
}