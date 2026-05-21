import java.util.Locale;
import java.util.Scanner;

public class DoWhile {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        char question;

        do {
            System.out.print("Digite a temperatura em Celsius:");
            double C = sc.nextDouble();
            double F = (9 * C ) / 5 + 32;

            System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
            sc.nextLine();

            System.out.print("Deseja repetir ( s / n ): ");
            question = sc.nextLine().charAt(0);
        }while(question == 's');
        sc.close();

    }

}
