import java.util.Scanner;

public class Function {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva os numeros: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int heigher = max(a, b, c);
        showResult(heigher);

        sc.close();
    }

    public static int max (int a, int b, int c){
        int aux;

        if (a > b && a > c){
            aux = a;
        } else if(b > c ) {
            aux = b;
        } else{
            aux = c;
        }
        return aux;
    }

    public static void showResult(int value) {
        System.out.printf("Maior numero: %d%n", value);
    }
}
