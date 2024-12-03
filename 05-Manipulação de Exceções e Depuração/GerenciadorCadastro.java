import java.util.logging.Level;
import java.util.logging.Logger;

// Exceção personalizada para validação de idade
class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

// Exceção personalizada para erro de cadastro
class CadastroIncompletoException extends RuntimeException {
    public CadastroIncompletoException(String mensagem) {
        super(mensagem);
    }
}

public class GerenciadorCadastro {
    // Logger para registrar eventos e erros
    private static final Logger LOGGER = Logger.getLogger(GerenciadorCadastro.class.getName());

    // Método para validar idade
    public void validarIdade(int idade) throws IdadeInvalidaException {
        LOGGER.info("Iniciando validação de idade: " + idade);
        
        if (idade < 18) {
            throw new IdadeInvalidaException("Idade inválida: Deve ser maior ou igual a 18.");
        }
        
        LOGGER.info("Validação de idade concluída com sucesso");
    }

    // Método para realizar cadastro com múltiplos tratamentos de exceção
    public void realizarCadastro(String nome, int idade, String email) {
        LOGGER.info("Iniciando processo de cadastro");
        
        try {
            // Validação de idade
            validarIdade(idade);
            
            // Simulação de validação de email
            if (email == null || email.isEmpty()) {
                throw new CadastroIncompletoException("Email não pode ser vazio");
            }
            
            // Simulação de divisão por zero para demonstrar tratamento de exceção
            int numeroCadastro = 100 / (2024 - idade);
            
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Número de Cadastro: " + numeroCadastro);
        
        } catch (IdadeInvalidaException e) {
            // Tratamento de exceção personalizada de idade
            LOGGER.severe("Erro de validação de idade: " + e.getMessage());
            e.printStackTrace();
        
        } catch (ArithmeticException e) {
            // Tratamento de exceção de divisão por zero
            LOGGER.warning("Erro de cálculo: " + e.getMessage());
            System.out.println("Não foi possível gerar o número de cadastro.");
        
        } catch (CadastroIncompletoException e) {
            // Tratamento de exceção de cadastro incompleto
            LOGGER.severe("Erro no cadastro: " + e.getMessage());
            System.out.println("Cadastro não pode ser concluído.");
        
        } catch (Exception e) {
            // Tratamento genérico para qualquer outro tipo de exceção
            LOGGER.log(Level.SEVERE, "Erro inesperado", e);
            System.out.println("Ocorreu um erro inesperado durante o cadastro.");
        
        } finally {
            // Bloco finally sempre executado
            LOGGER.info("Processo de cadastro finalizado");
            System.out.println("Fim do processo de cadastro.");
        }
    }

    public static void main(String[] args) {
        GerenciadorCadastro gerenciador = new GerenciadorCadastro();
        
        // Cenário 1: Cadastro bem-sucedido
        System.out.println("--- Cenário 1: Cadastro Válido ---");
        gerenciador.realizarCadastro("João Silva", 25, "joao@email.com");
        
        System.out.println("\n--- Cenário 2: Idade Inválida ---");
        // Cenário 2: Idade inválida
        gerenciador.realizarCadastro("Maria", 15, "maria@email.com");
        
        System.out.println("\n--- Cenário 3: Email Vazio ---");
        // Cenário 3: Email vazio
        gerenciador.realizarCadastro("Pedro", 30, "");
    }
}