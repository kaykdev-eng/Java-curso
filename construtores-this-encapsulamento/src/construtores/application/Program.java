package construtores.application;

import construtores.entitites.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Product Data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price:");
        double price = sc.nextDouble();

        Product product = new Product(name, price);

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