### Módulo 14: Cloud e Ferramentas de Integração

## 1. Introdução ao Deploy na Nuvem (AWS, Azure, GCP)

- O deploy na nuvem permite escalar e gerenciar aplicações de forma eficiente, utilizando provedores como AWS, Azure e GCP. Cada provedor oferece serviços como máquinas virtuais, bancos de dados gerenciados, balanceadores de carga, entre outros.

## 2. Deploy com Docker e Kubernetes

- **Docker** é usado para empacotar a aplicação e suas dependências em contêineres.
**Kubernetes (K8s)** é uma plataforma para orquestração de contêineres, facilitando o deploy, escalabilidade e gerenciamento.

**Exemplo: Criação de uma imagem Docker:**

- Crie um arquivo **Dockerfile**:

```dockerfile
FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/myapp.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

- Construa e rode a imagem:

```bash
docker build -t myapp .
docker run -p 8080:8080 myapp
```

**Exemplo: Deploy no Kubernetes:**

- Crie um arquivo **deployment.yaml**:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: myapp-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: myapp
        image: myapp:latest
        ports:
        - containerPort: 8080
```
- Aplique o deployment:

```bash
kubectl apply -f deployment.yaml
```

## 3. Configuração Centralizada com Spring Cloud Config

- O **Spring Cloud Config** centraliza as configurações de múltiplos serviços, permitindo mudanças dinâmicas sem a necessidade de rebuild ou redeploy.

**Exemplo: Configuração do Spring Cloud Config Server**:

- Adicione a dependência no **pom.xml**:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

- Habilite o Config Server:

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

- Configure o repositório de configurações **(application.yml)**:

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/meu-repositorio/config-repo
```

## 4. Apache Kafka para Streaming de Dados

- O Apache Kafka é uma plataforma de streaming distribuída usada para processar e transmitir dados em tempo real. Ele é ideal para arquiteturas baseadas em eventos.s

**Exemplo: Produção e consumo de mensagens com Spring Kafka**:

```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```
- Producer

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

- Consumer

```java
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
```

## 5. Monitoramento e Logging em Produção (Prometheus, Grafana)

- O monitoramento e logging são essenciais para identificar e resolver problemas em produção.

- **Prometheus**:

- Ferramenta de monitoramento e alerta.
- Coleta métricas em intervalos definidos.
- Configura alertas para condições específicas.

- **Grafana**:

- Ferramenta de visualização de métricas.
- Permite criar painéis interativos com base nas métricas do Prometheus.

- **Logging**:

- Utilize bibliotecas como Logback e SLF4J para registrar logs.
- Exemplo de configuração básica no **application.yml:**

```yaml
logging:
  level:
    root: INFO
    com.example.myapp: DEBUG
```
