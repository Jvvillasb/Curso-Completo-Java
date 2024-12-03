
public class Main {
    public static void main(String[] args) {
        // ===== Estruturas Condicionais =====
        int numero = 7;
        if (numero % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }

        char opcao = 'C';
        switch (opcao) {
            case 'A':
                System.out.println("Opção A selecionada.");
                break;
            case 'B':
                System.out.println("Opção B selecionada.");
                break;
            default:
                System.out.println("Opção não reconhecida.");
        }

        // ===== Estruturas de Repetição =====
        System.out.println("Usando for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteração " + i);
        }

        System.out.println("Usando while:");
        int contador = 5;
        while (contador > 0) {
            System.out.println("Contador: " + contador);
            contador--;
        }

        System.out.println("Usando do-while:");
        int valor = 0;
        do {
            System.out.println("Valor atual: " + valor);
            valor++;
        } while (valor < 3);

        // ===== Estruturas de Controle de Fluxo =====
        System.out.println("Usando break:");
        for (int i = 0; i < 10; i++) {
            if (i == 5) break;
            System.out.println("Valor: " + i);
        }

        System.out.println("Usando continue:");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println("Número ímpar: " + i);
        }
    }
}
