### 02-Estruturas de Controle e Fluxo

## 1. Estruturas Condicionais (if, else, switch)

- Programação é a arte de criar instruções precisas para que computadores resolvam problemas específicos.
- Utilizamos estruturas condicionais para controlar o fluxo de execução com base em condições.

### Tipos de Condicionais:

- **if e else**: Usados para decidir entre dois blocos de código com base em uma condição.
- **switch**: Usado para múltiplas condições baseadas em um único valor.

```java
int num = 5;  
if (num > 0) {  
    System.out.println("Número positivo.");  
} else {  
    System.out.println("Número não positivo.");  
}  

char opcao = 'B';  
switch (opcao) {  
    case 'A':  
        System.out.println("Opção A selecionada.");  
        break;  
    case 'B':  
        System.out.println("Opção B selecionada.");  
        break;  
    default:  
        System.out.println("Opção inválida.");  
}
```

## 2. Estruturas de Repetição (for, while, do-while)

- Repetição é uma forma de executar um bloco de código múltiplas vezes.

- Tipos de Estruturas de Repetição:
- **for**: Usado para loops com contadores.
- **while**: Continua enquanto a condição for verdadeira.
- **do-while**: Executa o bloco pelo menos uma vez antes de avaliar a condição.

```java
// Usando for:
for (int i = 1; i <= 5; i++) {
    System.out.println("Iteração " + i);
}

// Usando while:
int contador = 5;
while (contador > 0) {
    System.out.println("Contador: " + contador);
    contador--;
}

// Usando do-while:
int valor = 0;
do {
    System.out.println("Valor atual: " + valor);
    valor++;
} while (valor < 3);
```

## 3. Estruturas de Controle de Fluxo (Controle de Loops, break, continue)

#### Controle de Fluxo permite ajustar a execução dos loops.

### Comandos:

- **break**: Interrompe um loop ou um switch.
- **continue**: Passa para a próxima iteração do loop.

```java
// Usando break:
for (int i = 0; i < 10; i++) {
    if (i == 5) break;  
    System.out.println("Valor: " + i);
}

// Usando continue:
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  
    System.out.println("Número ímpar: " + i);
}
```