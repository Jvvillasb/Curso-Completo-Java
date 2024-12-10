import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // File Handling with java.io
        File file = new File("example.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Hello, world!");
            writer.newLine();
            writer.write("Java File Manipulation.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read (java.io): " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        // File Handling with java.nio
        Path path = Paths.get("nio_example.txt");
        List<String> lines = Arrays.asList("NIO Example Line 1", "NIO Example Line 2");
        try {
            Files.write(path, lines);
            System.out.println("Written (java.nio): " + lines);
        } catch (IOException e) {
            System.err.println("Error writing file (NIO): " + e.getMessage());
        }

        try {
            List<String> readLines = Files.readAllLines(path);
            readLines.forEach(line -> System.out.println("Read (java.nio): " + line));
        } catch (IOException e) {
            System.err.println("Error reading file (NIO): " + e.getMessage());
        }

        // Serialization and Deserialization
        Person person = new Person("Alice", 30);
        String serFile = "person.ser";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFile))) {
            oos.writeObject(person);
            System.out.println("Serialized: " + person);
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFile))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
        }
    }
}

// Serializable Class
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
