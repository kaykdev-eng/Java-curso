package exercicio_estatico.application;
import exercicio_estatico.entities.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price?: ");
        double dollarPrice = sc.nextDouble();

        System.out.print("How many dollars will be bought?: ");
        double dollarsBought = sc.nextDouble();

        double result = CurrencyConverter.amountToBePaid(dollarPrice, dollarsBought);

        System.out.printf("Amount to be paid in reais = %.2f%n", result);

        sc.close();

    }


}
