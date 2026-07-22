package application;

import entites.Book;
import entites.Movie;
import repository.Inventory;
import repository.InventoryPrinter;

import java.util.List;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Movie> movieInventory = new Inventory<>();
        InventoryPrinter inventoryPrinter = new InventoryPrinter();

        System.out.print("How many books? : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.printf("Book #%d:%n", i + 1);
            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            Book book = new Book(title, author);
            bookInventory.add(book);
        }

        System.out.print("How many movies? : ");
        int y = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < y; i++) {
            System.out.printf("Movie #%d:%n", i + 1);
            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Year: ");
            String year = sc.nextLine();

           Movie movie = new Movie(title, year);
           movieInventory.add(movie);
        }

        System.out.println("============= BOOKS =============");
        inventoryPrinter.print(bookInventory.findAll());

        System.out.println("============= MOVIES =============");
        inventoryPrinter.print(movieInventory.findAll());

        sc.close();
    }
}
