### 09-Conjuntos Avançados da Linguagem

## 1. Anotações Personalizadas

- Anotações personalizadas permitem adicionar metadados ao código que podem ser usados em tempo de compilação ou execução.

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Executar {
    String descricao() default "Método executável";
}

class Exemplo {
    @Executar(descricao = "Este método é um exemplo de anotação personalizada")
    public void meuMetodo() {
        System.out.println("Método executado!");
    }
}
```

## 2. Reflections

- Reflection é usada para inspecionar ou manipular **classes, métodos e campos** em tempo de execução.

```java
import java.lang.reflect.Method;

public class TesteReflection {
    public static void main(String[] args) throws Exception {
        Class<Exemplo> clazz = Exemplo.class;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Executar.class)) {
                Executar anotacao = method.getAnnotation(Executar.class);
                System.out.println("Executando: " + anotacao.descricao());
                method.invoke(clazz.getDeclaredConstructor().newInstance());
            }
        }
    }
}
```

## 3. Uso de Optional

- A classe **Optional** reduz a necessidade de verificações de **null**, tornando o código mais seguro e legível.

```java
import java.util.Optional;

public class TesteOptional {
    public static void main(String[] args) {
        Optional<String> nome = Optional.ofNullable(pegarNome());
        nome.ifPresentOrElse(
            n -> System.out.println("Nome: " + n),
            () -> System.out.println("Nome não disponível")
        );
    }

    public static String pegarNome() {
        return null; // Pode retornar um valor ou nullssss
    }
}
```

## 4. Module System (Java 9+)

- Introduzido no Java 9, o sistema de módulos permite dividir projetos em componentes menores e mais organizados.

- Arquivo **module-info.java** para definir um módulo:

```java
module meuModulo {
    exports com.joao.util; // Pacotes disponíveis para outros módulos
    requires outroModulo; // Dependência de outro módulo
}
```

- Classe em um módulo:

```java
package com.joao.util;

public class Utilidade {
    public static void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}
```

## 5. Introdução ao Pattern Matching e Switch Expressions

- Recursos mais recentes do Java permitem simplificar o código com **Pattern Matching** e **Switch Expresssions**.

- **Pattern Matching** (Java 16+):

```java
public class TestePatternMatching {
    public static void main(String[] args) {
        Object obj = "Texto exemplo";

        if (obj instanceof String s) {
            System.out.println("String com comprimento: " + s.length());
        }
    }
}
```

- **Switch Expressions** (Java 14+):

```java
public class TesteSwitch {
    public static void main(String[] args) {
        String dia = "SEGUNDA";

        String resultado = switch (dia) {
            case "SEGUNDA", "TERÇA" -> "Início da semana";
            case "SÁBADO", "DOMINGO" -> "Fim de semana";
            default -> "Meio da semana";
        };

        System.out.println(resultado);
    }
}
```
