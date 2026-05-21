package exercicioEstoque.application;

import exercicioEstoque.estities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter Product Data: ");
        System.out.print("Name: ");
        product.name = sc.nextLine();

        System.out.print("Price:");
        product.price = sc.nextDouble();

        System.out.print("Quantity in Stock: ");
        product.quantity = sc.nextInt();

        System.out.println("Product data: " + product);

        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println("Updated data: " + product);

        System.out.print("Enter the number of products to be removed in stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.println("Updated data: " + product);

        sc.close();
    }
}
