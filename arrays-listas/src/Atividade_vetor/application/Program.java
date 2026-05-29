package Atividade_vetor.application;

import Atividade_vetor.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Person[] vect = new Person[n];
        for (int i = 0; i < vect.length; i++) {
            System.out.printf("Dados da [%d]a pessoa:", i + 1);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Height: ");
            double height = sc.nextDouble();
            sc.nextLine();

            vect[i] = new Person(name, age, height);
        }
        double sum = 0.0;
        int minorQuantity = 0;

        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getHeight();

            if(vect[i].getAge() < 16) {
                minorQuantity++;
            }
        }
        double avgHeight = sum / vect.length;
        double minorPercentage = minorQuantity * 100.0 / vect.length;

        System.out.printf("Average height: %.2f%n", avgHeight);
        System.out.printf("People under 16 years old: %.1f%%%n", minorPercentage);

        for (int i = 0; i < vect.length; i++) {
            if(vect[i].getAge() < 16) {
                System.out.println(vect[i].getName());
            }
        }

        sc.close();
    }
}
