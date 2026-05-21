import java.util.Scanner;

public class While {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int quantity = 0;

        while(number != 0){
            quantity += number;
            number = sc.nextInt();
        }
        System.out.println(quantity);

        sc.close();

    }
}
