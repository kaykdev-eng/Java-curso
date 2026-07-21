package default_methods;

import default_methods.entites.BrazilInterestService;
import default_methods.entites.InterestService;
import default_methods.entites.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new UsaInterestService(1.0);
        double payment = is.payment(amount, months);

        System.out.printf("Result: $ %.2f", payment);

        sc.close();
    }
}
