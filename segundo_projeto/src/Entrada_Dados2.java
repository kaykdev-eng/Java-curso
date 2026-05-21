import java.util.Scanner;

public class Entrada_Dados2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int x;
        String s1, s2, s3;

        x = sc.nextInt();
        sc.nextLine();
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();

        System.out.println("Digitou:" + x + s1 + s2 + s3);


        sc.close();
    }
}
