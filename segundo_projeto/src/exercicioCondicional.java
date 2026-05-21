import java.util.Scanner;

public class exercicioCondicional {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        char invite;
        int hours;

        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.print("Idade: ");
        age = sc.nextInt();

        System.out.print("Possui convite?: ");
        invite = sc.next().charAt(0);

        System.out.print("Horas: ");
        hours = sc.nextInt();

        if(age>= 18 && invite == 's') System.out.println("Acesso permitido!");
        else if ( age < 18 && hours < 22) System.out.println("Entrada permitida apenas acompanhado!");
        else{ System.out.println("Acesso negado!"); }
        sc.close();

    }
}
