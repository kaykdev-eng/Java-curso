package exercicio2.application;

import exercicio2.entities.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Produto product = new Produto();
        int q;

        System.out.print("Nome do produto:");
        product.nameProduct = sc.nextLine();

        System.out.print("Preço do produto: ");
        product.priceProduct = sc.nextDouble();

        product.view(product.nameProduct, product.priceProduct, 0);

        System.out.print("Quantos produtos foram adicionados ao estoque?: ");
        q = sc.nextInt();
        product.addProduct(q);
        product.view(product.nameProduct, product.priceProduct, product.quantityProduct);

        System.out.print("Quantos produtos quer remover?: ");
        q = sc.nextInt();
        product.removeProduct(q);
        product.view(product.nameProduct, product.priceProduct, product.quantityProduct);
    }
}
