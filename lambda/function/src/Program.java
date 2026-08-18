import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        /*
       List<String> result = list.stream()
               .filter((p) -> p.getPrice() >= 100)
               .map(p -> p.getName().toUpperCase())
               .toList();

       result.forEach(System.out::println);
         */

        double sum = list.stream().filter(p -> p.getPrice() <= 100).mapToDouble(Product::getPrice).sum();
        System.out.println(sum);
    }
}
