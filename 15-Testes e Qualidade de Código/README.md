### Módulo 15: Testes e Qualidade de Código

## 1. Testes Unitários com JUnit

- Os testes unitários verificam funcionalidades individuais da aplicação, garantindo que métodos ou classes funcionem conforme esperado. O **JUnit** é a principal biblioteca usada para testes unitários no ecossistema Java.

**Exemplo: Criação de uma imagem Docker:**

1. Adicione a dependência ao `pom.xml`:

```xml
   <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter</artifactId>
       <version>5.9.0</version>
       <scope>test</scope>
   </dependency>
```

2. Implemente um teste básico:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(2, 3);
        assertEquals(5, resultado, "A soma deve ser 5");
    }
}
```

## 2. Testes de Integração com Spring Boot

- Os testes de integração verificam a interação entre componentes e dependem de contexto da aplicação. O Spring Boot facilita esses testes com o uso da anotação **@SpringBootTest.**

**Exemplo: Teste de Integração com Spring Boot:**

1. Adicione a dependência ao `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
2. Teste de um controlador:

```java
@SpringBootTest
@AutoConfigureMockMvc
public class MeuControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/saudacao"))
               .andExpect(status().isOk())
               .andExpect(content().string("Olá, mundo!"));
    }
}
```

## 3. Mocking com Mockito

- O **Mockito** é usado para criar mocks (simulações) de dependências em testes unitários, permitindo que você isole o comportamento da classe testada.

**Exemplo: Mockando Dependências:**

1. Adicione a dependência ao **pom.xml:**

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.10.0</version>
    <scope>test</scope>
</dependency>
```
2. Teste de um controlador:

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ServicoTest {

    @Test
    public void testBuscarUsuario() {
        RepositorioUsuario repositorioMock = Mockito.mock(RepositorioUsuario.class);
        when(repositorioMock.buscarPorId(1L)).thenReturn(new Usuario(1L, "João"));

        ServicoUsuario servico = new ServicoUsuario(repositorioMock);
        Usuario usuario = servico.buscarUsuario(1L);

        assertEquals("João", usuario.getNome());
        verify(repositorioMock, times(1)).buscarPorId(1L);
    }
}
```

## 4. Testes Automatizados de API

- Os testes de API garantem que endpoints funcionem corretamente. Ferramentas como RestAssured ou o suporte do Spring Boot (MockMvc) são amplamente usadas.

**Exemplo: Teste de API com RestAssured**

1. Adicione a dependência ao **pom.xml:**

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.0</version>
    <scope>test</scope>
</dependency>
```
2. Teste um endpoint:

```java
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testSaudacaoEndpoint() {
        RestAssured.baseURI = "http://localhost:8080/api/v1";

        given()
            .when().get("/saudacao")
            .then()
            .statusCode(200)
            .body(equalTo("Olá, mundo!"));
    }
}
```

## 5. Ferramentas de Análise de Código (SonarQube, PMD)

- Ferramentas como **SonarQube** e **PMD** ajudam a identificar problemas no código, como bugs, vulnerabilidades e violações de estilo. Essas ferramentas são fundamentais para manter a qualidade e a legibilidade do código.

**SonarQube**

- Analisa projetos em busca de bugs, code smells, vulnerabilidades e cobertura de testes.

- Para integrar o SonarQube com Maven:

1. Adicione a dependência ao **pom.xml:**

```xml
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
    <version>3.9.1.2184</version>
</plugin>
```
2. Execute a análise::

```java
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
```

**PMD**

- Verifica problemas comuns no código e fornece sugestões para melhoria.

- Configuração básica no Maven:

1. Adicione a dependência ao **pom.xml:**

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-pmd-plugin</artifactId>
    <version>3.14.0</version>
    <configuration>
        <rulesets>
            <ruleset>/rulesets/java/basic.xml</ruleset>
        </rulesets>
    </configuration>
</plugin>
```
