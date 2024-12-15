### Módulo 13: Microserviços e Arquitetura Avançada

## 1. Introdução a Microserviços

- Os microserviços são uma abordagem de arquitetura onde uma aplicação é dividida em serviços pequenos, independentes e especializados, que comunicam entre si.  
  Cada microserviço é implementado, implantado e escalado de forma independente, o que aumenta a flexibilidade e a resiliência.

**Características principais:**

- Separação de responsabilidades.
- Independência de implementação.
- Comunicação via APIs (REST, gRPC, Messaging).

**Exemplo de estrutura básica de microserviços**:

- User Service -> API REST para Gerenciamento de Usuários Order Service -> API REST para Processamento de Pedidos Payment Service -> API REST para Pagamentos

## 2. Comunicação entre Microserviços (REST, gRPC, Messaging)

- **REST**: Comunicação síncrona via HTTP.
- **gRPC**: Comunicação baseada em Protobuf, mais eficiente e binária.
- **Mensageria**: Comunicação assíncrona com ferramentas como RabbitMQ ou Kafka.

**Exemplo de comunicação via REST**:

```java
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public OrderResponse getOrdersForUser(@PathVariable Long userId) {
        UserResponse user = restTemplate.getForObject("http://user-service/users/" + userId, UserResponse.class);
        // Lógica de negócios utilizando resposta do User Service
        return new OrderResponse(user.getName(), List.of("Order1", "Order2"));
    }
}
```

**Exemplo de comunicação com Kafka (mensageria):**:

```java
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
```

## 3. Circuit Breaker e Resiliência com Resilience4j

- Circuit breakers previnem falhas em cascata e aumentam a resiliência da aplicação ao interromper chamadas para serviços que estão indisponíveis.
- O **Resilience4j** é uma biblioteca leve para implementar circuit breakers, retry, rate limiters, etc.

**Exemplo de configuração de Circuit Breaker:**

```java
@CircuitBreaker(name = "userService", fallbackMethod = "fallbackForUserService")
public UserResponse getUser(Long userId) {
    return restTemplate.getForObject("http://user-service/users/" + userId, UserResponse.class);
}

public UserResponse fallbackForUserService(Long userId, Throwable throwable) {
    return new UserResponse(userId, "Fallback User", "N/A");
}

```

## 4. Service Discovery com Spring Cloud

- O Service Discovery permite que os microserviços encontrem dinamicamente outros serviços no ecossistema.
- **Eureka Server**, parte do Spring Cloud Netflix, é uma solução popular para Service Discovery.

**Exemplo de configuração do Eureka Server:**

 - Adicione a dependência no pom.xml:

```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

 - Ative o servidor Eureka:
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

- Exemplo de cliente Eureka:
```java
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
```

## 5. API Gateway e Balanceamento de Carga

- O API Gateway funciona como uma porta de entrada única para os microserviços, fornecendo funcionalidades como roteamento, autenticação e balanceamento de carga.
Spring Cloud Gateway é uma solução leve e flexível para isso.
- **Exemplo de configuração do Gateway:**

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/orders/**

```

## 6. Autenticação e Autorização em Arquiteturas Distribuídas

- A autenticação e autorização em sistemas distribuídos podem ser feitas com OAuth2 e JWT, garantindo segurança sem estado.
- O API Gateway pode ser responsável por validar os tokens antes de encaminhar as requisições para os microserviços.
- **Exemplo de validação de token JWT no Gateway:**

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: secure-route
          uri: http://secure-service
          predicates:
            - Path=/secure/**
          filters:
            - TokenRelay
```

```java
public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 3600000))
        .signWith(SignatureAlgorithm.HS512, "secretKey")
        .compact();
}
```