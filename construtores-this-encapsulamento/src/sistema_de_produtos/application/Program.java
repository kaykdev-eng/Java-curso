package sistema_de_produtos.application;

import sistema_de_produtos.entites.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product;

        System.out.print("Enter product name: ");
        String productName = sc.nextLine();

        System.out.print("Enter to a product price: ");
        double productPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Have some quantity to enter? (y / n) ");
        char response = sc.nextLine().charAt(0);

        if(response == 'y') {
            System.out.print("Enter to quantity: ");
            int InitialQuantity = sc.nextInt();
            product = new Product(productName, productPrice, InitialQuantity);
            System.out.println(product);
        }else {
            product = new Product(productName, productPrice);
            System.out.println(product);
        }

        System.out.print("Units to enter: ");
        int quantityValue = sc.nextInt();
        product.addQuantity(quantityValue);
        System.out.println(product);

        System.out.print("Units to remove: ");
        int removeQuantity = sc.nextInt();
        sc.nextLine();
        product.removeToStock(removeQuantity);
        System.out.println(product);

        System.out.print("Descont in product? (y / n): ");
        char responseDescont = sc.nextLine().charAt(0);
        if(responseDescont == 'y') {
            System.out.print("Enter discount percentage: ");
            int valueDescont = sc.nextInt();
            product.descontInProduct(valueDescont);
            System.out.println(product);
            sc.nextLine();
        }

        System.out.println("Increase price to product? ( y / n )");
        char responsePrice = sc.nextLine().charAt(0);
        if (responsePrice == 'y') {
            System.out.print("Enter increase price: ");
            int increaseValue = sc.nextInt();
            product.increasePrice(increaseValue);
            System.out.println(product);
            sc.nextLine();
        } else {
            System.out.println(product);
        }
        sc.close();
    }
}
