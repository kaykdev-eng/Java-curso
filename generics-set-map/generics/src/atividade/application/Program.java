package atividade.application;

import atividade.repository.InMemoryRepository;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InMemoryRepository<String> repositoryMovies = new InMemoryRepository<>();
        InMemoryRepository<Integer> repositoryAges = new InMemoryRepository<>();

        System.out.println("3 movies names: ");
        for (int i = 0; i < 3; i++) {
            String names = sc.nextLine();
            repositoryMovies.addToList(names);
        }
        System.out.println("---------------------------------------");

        System.out.println("3 ages: ");
        for (int i = 0; i < 3; i++) {
            int ages = sc.nextInt();
            repositoryAges.addToList(ages);
        }

        System.out.println("---------------------------------------");


        System.out.println("Movies: ");
        for(String n : repositoryMovies.findAll()) {
            System.out.println(n);
        }
        System.out.println("---------------------------------------");

        System.out.println("ages: ");
        for(int n : repositoryAges.findAll()) {
            System.out.println(n);
        }


        sc.close();
    }
}
