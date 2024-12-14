import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Optional;

// Anotação personalizada
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Executar {
    String descricao() default "Método executável";
}

public class ReflectionAndAnnotations {
    public static void main(String[] args) {
        // Exemplo de Reflection com Anotação Personalizada
        try {
            Class<?> clazz = ReflectionAndAnnotations.class;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Executar.class)) {
                    Executar anotacao = method.getAnnotation(Executar.class);
                    System.out.println("Executando: " + anotacao.descricao());
                    method.invoke(null); // Chamando método estático
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exemplo de Optional
        Optional<String> nome = Optional.ofNullable(pegarNome());
        nome.ifPresentOrElse(
            n -> System.out.println("Nome disponível: " + n),
            () -> System.out.println("Nome não disponível")
        );

        // Exemplo de Pattern Matching
        Object obj = "Texto exemplo";
        if (obj instanceof String s) {
            System.out.println("Pattern Matching: A string tem " + s.length() + " caracteres.");
        }

        // Exemplo de Switch Expressions
        String dia = "SÁBADO";
        String resultado = switch (dia) {
            case "SEGUNDA", "TERÇA" -> "Início da semana";
            case "SÁBADO", "DOMINGO" -> "Fim de semana";
            default -> "Meio da semana";
        };
        System.out.println("Switch Expression: " + resultado);
    }

    // Método anotado com Executar
    @Executar(descricao = "Método exemplo usando anotação personalizada")
    public static void metodoComAnotacao() {
        System.out.println("Método com anotação executado!");
    }

    // Método para Optional
    public static String pegarNome() {
        return null; // Pode ser alterado para "João Vitor" para testar
    }
}
