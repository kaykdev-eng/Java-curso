import java.util.Scanner;

public class Strings {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome completo:");
        String name = sc.nextLine();
        String[] vect = name.trim().split(" ");

        System.out.printf("Nome em maiúsculo: %s%n", name.toUpperCase());
        System.out.printf("Nome em minúsculo: %s%n", name.toLowerCase());
        System.out.printf("Nome sem espaços extras: %s%n", name.trim());
        System.out.printf("Quantidade de caracteres: %s%n", name.length());
        System.out.printf("Primeiro nome %s%n", name.substring(0, name.indexOf(" ")));
        for(int i = 0; i < vect.length; i++) {
            System.out.printf("Posição [%d]: %s%n  ", i, vect[i]);
        };




    }
}
