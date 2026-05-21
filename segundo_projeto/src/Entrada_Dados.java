import java.util.Scanner;

public class Entrada_Dados {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char x;
        x = sc.next().charAt(0);
        System.out.println("Voce digitou: " + x);




        sc.close();
    }
}
