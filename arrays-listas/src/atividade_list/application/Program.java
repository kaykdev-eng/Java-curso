package atividade_list.application;

import atividade_list.entites.Employeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employeer> employeers = new ArrayList<>();

        System.out.print("How many employeers will be registered? ");
        int x = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < x; i++) {
            System.out.printf("Employeer #%d:%n", i + 1);
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            employeers.add( new Employeer(id, name, salary) );
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int idToIncrease = sc.nextInt();
        boolean found = false;
        sc.nextLine();
        for (Employeer y : employeers) {
            if(y.getId() == idToIncrease) {
                System.out.print("Enter the percentage: ");
                int percentage = sc.nextInt();
                y.bonusPercentage(percentage);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("This id does not exist!");
        }

        System.out.println("List of employees:");
        for(Employeer y : employeers) {
            System.out.println(y);
        }

        sc.close();
    }
}
