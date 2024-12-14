### 11-Desenvolvimento Web com Java (Backend)

- ***OBS:*** Não Tem trecho de código nesse Exemplo, mas todas referências são do Arquivo **ThreadsAndParallelism.java** desse módulo

## 1. Fundamentos de Web Services

- Web Services permitem a comunicação entre aplicações através da web, utilizando protocolos como HTTP. Existem dois tipos principais:
- **SOAP** (Protocolo mais formal e pesado).
- **REST** (Protocolo mais leve e amplamente utilizado).

- RESTful APIs utilizam operações HTTP como GET, POST, PUT e DELETE para manipular recursos.

**Exemplo simples de API RESTful com Spring Boot**:
```java
@RestController
@RequestMapping("/api")
public class HelloWorldController {
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

## 2. RESTful APIs com Spring Boot

- O Spring Boot simplifica a criação de APIs RESTful ao integrar ferramentas de configuração, controle de rotas e manipulação de dados.
**Exemplo de CRUD básico com Spring Boot:**
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Lógica para buscar o usuário
        return ResponseEntity.ok(new User(id, "João", "joao@email.com"));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Lógica para criar o usuário
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
```

## 3. Segurança com Spring Security (OAuth2, JWT)

- Spring Security oferece integração com protocolos de segurança, como OAuth2 e JWT, para proteger APIs RESTful.

- **OAuth2**: é um protocolo de autorização que permite que aplicativos acessem recursos em nome de um usuário.
- **JWT (JSON Web Tokens)**: permite autenticação sem estado, útil para microsserviços.

**Exemplo básico de configuração de segurança com JWT:**
```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthenticationFilter(authenticationManager()));
    }
}
```

## 4. Configuração e Monitoramento

- Ferramentas como Actuator e Spring Boot Admin são úteis para monitorar e configurar aplicações em produção.
- **Exemplo** com Spring Boot Actuator: Adicione a dependência no pom.xml:

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## 5. Documentação com Swagger/OpenAPI

- **Swagger/OpenAPI** fornece ferramentas para documentar e testar APIs RESTful de forma interativa.
- **Exemplo básico de configuração do Swagger com Spring Boot**: Adicione a dependência no **pom.xml**:

```java
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.15</version>
</dependency>
```
- **Documente suas APIs com anotações:**

```java
@RestController
@RequestMapping("/api")
@Tag(name = "Exemplo API", description = "Exemplo de documentação com Swagger")
public class ExampleController {

    @Operation(summary = "Buscar mensagem de exemplo")
    @GetMapping("/example")
    public String getExample() {
        return "Exemplo de documentação com Swagger!";
    }
}
```

