### 05-Manipulação de Exceções e Depuração

## 1. Tratamento de Exceções

- Utiliza os blocos **try-catch** para capturar erros durante a execução.

- O bloco **finally** é usado para executar códigos que devem ser rodados, independentemente de haver uma exceção.

- A palavra-chave **throws** é usada para propagar exceções.

```java
try {
    int resultado = 10 / 0; // Gera uma ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Erro: Divisão por zero!");
} finally {
    System.out.println("Bloco finally executado.");
}
```

### 2. Exceções Personalizadas

- Criar classes que estendem **Exception** ou **RuntimeException** para representar erros específicos da aplicação.

```java
class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}

void validarIdade(int idade) throws MinhaExcecao {
    if (idade < 18) {
        throw new MinhaExcecao("Idade inválida: Deve ser maior ou igual a 18.");
    }
}
```

## 3. Uso de StackTrace para Debugging

- O método **printStackTrace()** exibe a sequência de chamadas que levaram à exceção.

- Ajuda a localizar o ponto exato onde ocorreu o erro.

```java
try {
    int[] numeros = {1, 2, 3};
    System.out.println(numeros[5]); // Índice inválido
} catch (ArrayIndexOutOfBoundsException e) {
    e.printStackTrace();
}
```

## 4. Depuração e Logs com java.util.logging

- A API **java.util.logging** oferece formas de registrar mensagens de log em níveis como **INFO**, **WARNING**, e **SEVERE**.

```java
import java.util.logging.Logger;

public class LoggerExemplo {
    private static final Logger logger = Logger.getLogger(LoggerExemplo.class.getName());

    public static void main(String[] args) {
        logger.info("Início da aplicação");
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            logger.severe("Erro: " + e.getMessage());
        }
        logger.info("Fim da aplicação");
    }
}
```