### 06-Coleções e Estruturas de Dados

## 1. Introdução ao Framework Collections

- O Framework Collections do Java fornece classes e interfaces para manipulação de grupos de objetos, como listas, conjuntos e mapas. 
Ele inclui interfaces como **List, Set, Map** e implementações populares como **ArrayList, HashSet, e HashMap.**

```java
// Exemplo básico: Criação de uma lista e adição de elementos
import java.util.*;

List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
System.out.println("Nomes: " + names);
```

## 2. List, Set, e Map

- **List**: Permite elementos duplicados e mantém a ordem de inserção. Exemplo: **ArrayList, LinkedList.**
- **Set**: Não permite elementos duplicados e pode ou não manter a ordem. Exemplo: **HashSet, TreeSet.**
- **Map**: Armazena pares de chave-valor, não permitindo chaves duplicadas. Exemplo: **HashMap, TreeMap.**

```java
// Trabalhando com List
List<Integer> numbers = Arrays.asList(10, 20, 30);
numbers.forEach(System.out::println);
```

```java
// Trabalhando com Set
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Alice");
uniqueNames.add("Bob");
uniqueNames.add("Alice"); // Duplicado, será ignorado
System.out.println("Set: " + uniqueNames);
```

```java
// Trabalhando com Map
Map<String, Integer> ageMap = new HashMap<>();
ageMap.put("Alice", 25);
ageMap.put("Bob", 30);
System.out.println("Idade de Alice: " + ageMap.get("Alice"));
```

## 3. ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap

- **ArrayList**: Implementação de List baseada em arrays dinâmicos.
- **LinkedList**: Implementação de List baseada em uma lista encadeada.
- **HashSet**: Implementação de Set que usa hash para armazenar elementos, sem ordem específica.
- **TreeSet**: Implementação de Set que mantém os elementos ordenados.
- **HashMap**: Implementação de Map baseada em tabelas hash.
- **TreeMap**: Implementação de Map que mantém as chaves ordenadas.

```java
// ArrayList
List<String> arrayList = new ArrayList<>();
arrayList.add("Elemento 1");
arrayList.add("Elemento 2");
System.out.println("ArrayList: " + arrayList);

// LinkedList
List<String> linkedList = new LinkedList<>();
linkedList.add("Elemento A");
linkedList.add("Elemento B");
System.out.println("LinkedList: " + linkedList);
```

```java
// HashSet
Set<Integer> hashSet = new HashSet<>(Arrays.asList(3, 1, 2, 3));
System.out.println("HashSet: " + hashSet);

// TreeSet
Set<Integer> treeSet = new TreeSet<>(Arrays.asList(3, 1, 2));
System.out.println("TreeSet: " + treeSet);
```

```java
// HashMap
Map<String, String> hashMap = new HashMap<>();
hashMap.put("C", "Cachorro");
hashMap.put("A", "Ave");
System.out.println("HashMap: " + hashMap);

// TreeMap
Map<String, String> treeMap = new TreeMap<>();
treeMap.put("C", "Cachorro");
treeMap.put("A", "Ave");
System.out.println("TreeMap: " + treeMap);
```

## 4. Manipulação e Ordenação de Coleções

- Métodos de manipulação incluem **add, remove, contains,** etc.
- A ordenação pode ser feita com **Collections.sort()** para listas e com comparadores personalizados usando **Comparable** ou **Comparator**.

```java
// Ordenando uma lista
List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
Collections.sort(list);
System.out.println("Lista Ordenada: " + list);
```

## 5. Streams e Manipulação de Dados

- **Streams** facilitam o processamento de coleções de dados, como filtragem, mapeamento e redução.
- **Exemplos**: stream().filter(), stream().map(), stream().collect().

```java
// Filtrando elementos com Stream
List<String> items = Arrays.asList("banana", "maçã", "uva");
items.stream()
     .filter(item -> item.startsWith("m"))
     .forEach(System.out::println); // Saída: maçã
```

```java
// Transformando elementos com Stream
List<String> upperCaseItems = items.stream()
    .map(String::toUpperCase)
    .toList();
System.out.println("Maiúsculas: " + upperCaseItems);
```

## 6. Comparadores (Comparable e Comparator)

- **Comparable**: Define a ordem natural de um objeto, implementando o método compareTo().
- **Comparator**: Define regras de comparação personalizadas, implementando o método compare().

```java
// Classe implementando Comparable
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25));
Collections.sort(people); // Ordena por idade
System.out.println("Pessoas Ordenadas: " + people);
```

```java
// Comparator para ordenar por nome
people.sort(Comparator.comparing(person -> person.name));
System.out.println("Pessoas Ordenadas por Nome: " + people);
```