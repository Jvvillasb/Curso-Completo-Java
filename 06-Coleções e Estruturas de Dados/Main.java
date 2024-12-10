import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // LIST Example
        List<String> arrayList = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange"));
        arrayList.add("Grape");
        Collections.sort(arrayList); // Ordenação
        System.out.println("Sorted List: " + arrayList);

        // SET Example
        Set<String> hashSet = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange", "Apple")); // Duplicates ignored
        System.out.println("HashSet (No Order): " + hashSet);

        Set<String> treeSet = new TreeSet<>(hashSet); // Ordenado
        System.out.println("TreeSet (Ordered): " + treeSet);

        // MAP Example
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        System.out.println("HashMap (No Order): " + hashMap);

        Map<Integer, String> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap (Ordered by Key): " + treeMap);

        // STREAM Example
        List<String> filteredList = arrayList.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered List (Starts with A): " + filteredList);

        // Comparable and Comparator Example
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Sorting using Comparable (natural order by age)
        Collections.sort(people);
        System.out.println("People sorted by age (Comparable): " + people);

        // Sorting using Comparator (custom order by name)
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("People sorted by name (Comparator): " + people);
    }
}

// Person Class
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // Natural order by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
