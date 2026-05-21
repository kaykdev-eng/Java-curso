import java.util.Scanner;

public class ExercicioWhile {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int password = 2002;
        int tryPassword = sc.nextInt();

        while(tryPassword != password){
            System.out.println("Senha incorreta");
            tryPassword = sc.nextInt();
        }

        sc.close();
    }
}
