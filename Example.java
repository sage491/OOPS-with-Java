import java.util.*;

public class Example {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram","Shyam","Rita","Rohan");

        names.stream()
             .filter(n -> n.startsWith("R"))
             .forEach(System.out::println);
    }
}