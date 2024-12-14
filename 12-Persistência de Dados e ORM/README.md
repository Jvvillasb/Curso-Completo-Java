### 12-Persistência de Dados e ORM

## 1. Banco de Dados Relacional e SQL Básico.

- Bancos de dados relacionais, como MySQL, PostgreSQL e Oracle, organizam dados em tabelas relacionadas. SQL (Structured Query Language) é a linguagem usada para gerenciar esses dados.

**Exemplo de criação de tabela em SQL**:

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 
```

**Exemplo de consulta SQL básica**:

```sql
SELECT * FROM users WHERE email = 'joao@email.com';
```

## 2. JPA e Hibernate

- O JPA (Java Persistence API) é uma especificação para gerenciamento de dados em Java. Hibernate é uma implementação popular do JPA, que simplifica o mapeamento entre objetos Java e tabelas do banco de dados.
**Exemplo de entidade JPA com Hibernate:**

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Getters e Setters
}
```

## 3. Mapeamento Objeto-Relacional (ORM)

- O ORM (Object-Relational Mapping) permite mapear classes e seus atributos para tabelas e colunas no banco de dados. Anotações JPA são usadas para definir esse mapeamento.
**Exemplo de relacionamento @OneToMany:**

```java
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    // Getters e Setters
}

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Getters e Setters
}
```

## 4. Repositórios com Spring Data JPA

- O Spring Data JPA simplifica o acesso a dados com a criação automática de métodos CRUD (Create, Read, Update, Delete) para entidades.
**Exemplo de repositório JPA básico:**

```java
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados podem ser adicionados aqui
    Optional<User> findByEmail(String email);
}
```

**Exemplo de uso em um serviço:**

```java
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
```

## 5. Transações e Controle de Conexão

- Spring oferece suporte a transações com a anotação **@Transactional**, garantindo que as operações no banco de dados sejam atômicas e consistentes.
- **Exemplo de método transacional:**

```java
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta origem não encontrada"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta destino não encontrada"));

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
```

```java
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.hikari.maximum-pool-size=10
spring.jpa.hibernate.ddl-auto=update 
```