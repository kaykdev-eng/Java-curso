import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("TV", 100.00));
        productList.add(new Product("Notbook", 1200.00));
        productList.add(new Product("PS5", 5000.00));

        productList.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        productList.forEach(System.out::println);


    }
}
