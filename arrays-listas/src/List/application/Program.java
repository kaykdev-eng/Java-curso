package List.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Joao");
        list.add("Joana");
        list.add("Maria");
        list.add("Kayk");
        list.add("Kaetano");
        list.add("Eduarda");
        list.add("Eduardo");
        list.add("Elana");
        list.add(2, "Luciano");
        System.out.println(list.size());

        for(String x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------------------------");

        list.removeIf(x -> x.charAt(0) == 'K');
        for(String x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------------------------");
        System.out.println("Index of Eduarda: " + list.indexOf("Eduarda"));

        System.out.println("---------------------------------------");
        List<String> result = list.stream().filter(x -> x.startsWith("E")).collect(Collectors.toList());

        for(String x : result) {
            System.out.println(x);
        }

        System.out.println("---------------------------------------");

        String name = list.stream().filter( x -> x.startsWith("J")).findFirst().orElse(null);
        System.out.println(name);


    }
}
