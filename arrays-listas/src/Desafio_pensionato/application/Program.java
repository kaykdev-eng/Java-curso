package Desafio_pensionato.application;

import Desafio_pensionato.entites.RoomRegistration;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RoomRegistration[] rooms = new RoomRegistration[10];
        System.out.print("How many rooms will be rented? ");
        int roomRented = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < roomRented; i++) {
            System.out.printf("Rent #%d:%n", i + 1);
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Room: ");
            int room = sc.nextInt();
            sc.nextLine();

            if (rooms[room] == null) {
                rooms[room] = new RoomRegistration(name, email);
            }else{
                System.out.println("Quarto alugado, tente novamente!");
                return;
            }
        }

        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] != null) {
                System.out.printf("%d: %s, %s%n",i, rooms[i].getName(), rooms[i].getEmail());
            }
        }

        sc.close();
    }
}
