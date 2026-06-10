package polimorfismo.system_product.application;

import polimorfismo.system_product.entites.ImportedProduct;
import polimorfismo.system_product.entites.Product;
import polimorfismo.system_product.entites.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        Product product;

        System.out.print("Enter the number of product: ");
        int n = sc.nextInt();
        sc.nextLine();
        char response;

        for (int i = 0; i < n; i++) {
            System.out.printf("Product #%d data:%n", i + 1);
            System.out.println("Commom, used or imported (c/u/i)?");
            response = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();

            switch (response) {
                case 'c' :
                    product = new Product(name, price);
                    products.add(product);
                break;

                case 'u' :
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.print("Manufacture date ( DD/MM/YYYY ): ");
                    String dateStr = sc.nextLine();
                    LocalDate date = LocalDate.parse(dateStr, fmt);
                    product = new UsedProduct(name, price, date);
                    products.add(product);
                break;

                case 'i' :
                    System.out.print("Custom free: ");
                    Double cf = sc.nextDouble();
                    sc.nextLine();
                    product = new ImportedProduct(name, price, cf);
                    products.add(product);
                break;

                default:
                    System.out.println("Enter the correct alternatives (c/u/i) !");
                break;
            }
        }

        System.out.println("PRICE TAGS:");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
