import java.util.Scanner;

public class swithCase {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day;
        day = sc.nextInt();

        switch (day){
            case 1:
                System.out.println("Domingo!");
            break;

            case 2:
                System.out.println("Segunda");
            break;

            case 3:
                System.out.println("Terça");
            break;

            case 4:
                System.out.println("Quarta");
                break;

            case 5:
                System.out.println("Quinta");
            break;
            default:
                System.out.println("Valor invalido!");
            break;
        }
    }
}
