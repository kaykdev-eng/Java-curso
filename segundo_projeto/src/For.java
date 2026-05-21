import java.util.Scanner;

public class For {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int soma = 0;

        for(int i =0; i < n; i++){
            int y = sc.nextInt();
            soma += y;
        }

        System.out.println(soma);
        sc.close();
    }
}
