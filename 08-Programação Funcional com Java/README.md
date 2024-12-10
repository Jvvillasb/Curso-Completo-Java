### 08-Programação Funcional com Java

## 1. Expressões Lambda

- As expressões lambda permitem criar funções anônimas concisas, eliminando a necessidade de classes anônimas para implementar interfaces funcionais.

```java
// Expressão Lambda simples
Runnable runnable = () -> System.out.println("Olá, Lambda!");
new Thread(runnable).start();

// Usando Lambda para somar dois números
interface Somador {
    int somar(int a, int b);
}

Somador somador = (a, b) -> a + b;
System.out.println("Resultado da soma: " + somador.somar(5, 3));
```

## 2. Manipulação de Dados com java.nio

- A API **java.nio** fornece mais eficiência para manipulação de arquivos e dados com classes como **Paths, Files, e ByteBuffer**.
Exemplos:
- **Paths.get()**: Cria um caminho para um arquivo ou diretório.
- **Files.readAllLines()**: Lê todas as linhas de um arquivo.
- **Files.write()**: Escreve dados em um arquivo.

```java
import java.nio.file.*;
import java.util.*;

// Escrever em um arquivo usando java.nio
Path path = Paths.get("nio_example.txt");
List<String> lines = Arrays.asList("Linha 1 com NIO", "Linha 2 com NIO");
try {
    Files.write(path, lines);
    System.out.println("Arquivo escrito com sucesso!");
} catch (IOException e) {
    System.err.println("Erro ao escrever arquivo: " + e.getMessage());
}

// Ler o conteúdo de um arquivo com java.nio
try {
    List<String> readLines = Files.readAllLines(path);
    readLines.forEach(line -> System.out.println("Conteúdo: " + line));
} catch (IOException e) {
    System.err.println("Erro ao ler arquivo: " + e.getMessage());
}
```

## 3. Serialização e Desserialização

- **Serialização**: Processo de converter um objeto em uma sequência de bytes para armazenamento ou transmissão.
- **Desserialização**: Processo inverso, convertendo bytes em um objeto.
- **Classes relacionadas**:
- **ObjectOutputStream**: Serializa objetos para um fluxo.
- **ObjectInputStream**: Desserializa objetos de um fluxo.
- Objetos devem implementar a interface **Serializable.**

```java
import java.io.*;

// Classe serializável
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

// Serializar um objeto
Person person = new Person("Alice", 25);
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
    oos.writeObject(person);
    System.out.println("Objeto serializado: " + person);
} catch (IOException e) {
    System.err.println("Erro na serialização: " + e.getMessage());
}

// Desserializar o objeto
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
    Person deserializedPerson = (Person) ois.readObject();
    System.out.println("Objeto desserializado: " + deserializedPerson);
} catch (IOException | ClassNotFoundException e) {
    System.err.println("Erro na desserialização: " + e.getMessage());
}
```

## 4. Leitura e Escrita de Arquivos

- **Métodos comuns:**
- Leitura linha por linha com **BufferedReader**.
- Escrita com **BufferedWriter**.
- Manipulação eficiente com **java.nio.file.Files.**


```java
// Leitura e escrita simples com java.io
File simpleFile = new File("simple.txt");
try (BufferedWriter writer = new BufferedWriter(new FileWriter(simpleFile))) {
    writer.write("Exemplo de escrita simples.");
} catch (IOException e) {
    System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
}

try (BufferedReader reader = new BufferedReader(new FileReader(simpleFile))) {
    String content;
    while ((content = reader.readLine()) != null) {
        System.out.println("Lido: " + content);
    }
} catch (IOException e) {
    System.err.println("Erro ao ler o arquivo: " + e.getMessage());
}
```