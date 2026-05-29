package Vetores_com_objeto.application;

import Vetores_com_objeto.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Product[] vect = new Product[n];

        for(int i = 0; i < vect.length; i++) {
            System.out.printf("Nome do produto numero [%d]: ", i + 1);
            String name = sc.nextLine();

            System.out.printf("Preço do produto numero [%d]: ", i + 1);
            double price = sc.nextDouble();
            sc.nextLine();

            vect[i] = new Product(name, price);
        }

        double sum = 0.0;
        for(int i = 0; i < vect.length; i++) {
            sum += vect[i].getPrice();
        }
        double avg = sum / vect.length;
        System.out.printf("Preço médio: %.2f%n", avg);

        sc.close();
    }
}
