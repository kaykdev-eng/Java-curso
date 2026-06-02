package Atividade_final_modulo.application;

import Atividade_final_modulo.entites.Employeer;
import Atividade_final_modulo.entites.Product;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employeer> employeer = new ArrayList<Employeer>();
        List<Product> product = new ArrayList<Product>();

        registerEmployeer(employeer, sc);
        registerProduct(product, sc);
        salaryIncrease(employeer, sc);
        productControl(product, sc);

        System.out.println("Final result: ");
        printEmployeers(employeer);
        printProducts(product);

        sc.close();
    }


    public static void registerEmployeer(List<Employeer> employeer, Scanner sc) {
        System.out.print("How many employeers will be to cadastred? ");
        int x  = sc.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.printf("Employeer number #%d%n", i + 1);
            System.out.print("Id: ");
            int ID = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String NAME = sc.nextLine();
            System.out.print("Salary: ");
            double SALARY = sc.nextDouble();
            employeerCadaster(employeer, ID, NAME, SALARY);
        }
    }

    public static void employeerCadaster(List<Employeer> employeer, int ID, String NAME, double SALARY) {
        employeer.add( new Employeer( ID, NAME, SALARY ));
    }

    public static void printEmployeers(List<Employeer> employeers) {
        for(Employeer employeer : employeers) {
            System.out.println(employeer);
        }
    }

    public static void registerProduct(List<Product> product, Scanner sc) {
        System.out.print("How many products will be to cadastred? ");
        int p = sc.nextInt();
        char question;
        sc.nextLine();
        for (int i = 0; i < p; i++) {
            System.out.printf("Product number #%d%n", i + 1);
            System.out.print("Id: ");
            int ID = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String NAME = sc.nextLine();
            System.out.print("Price: ");
            double PRICE = sc.nextDouble();
            sc.nextLine();

            System.out.print("Does it have an initial quantity? ( y / n ): ");
            question = sc.nextLine().charAt(0);
            if( question == 'y' ) {
                System.out.print("Initial quantity: ");
                int QUANTITY = sc.nextInt();
                productCadaster(product, ID, NAME, PRICE, QUANTITY);
            } else {
                productCadasterNoQuantity(product, ID, NAME, PRICE);
            }
        }
    }

    public static void productCadaster(List<Product> product, int ID, String NAME, double PRICE, int QUANTITY) {
        product.add( new Product(ID, NAME, PRICE, QUANTITY));
    }

    public static void productCadasterNoQuantity(List<Product> product, int ID, String NAME, double PRICE) {
        product.add( new Product(ID, NAME, PRICE));
    }

    public static void printProducts(List<Product> product) {
        for(Product products : product) {
            System.out.println(products);
        }
    }

    public static void salaryIncrease(List<Employeer> employeer, Scanner sc) {
        System.out.print("Enter the employee id that will have salary increase: ");
        int ID = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for(Employeer y : employeer) {
            if(y.getID() == ID) {
                System.out.print("Enter the percentage: ");
                int percentage = sc.nextInt();
                y.increaseSalary(percentage);
                found = true;
                break;
            } else if (!found) {
                System.out.println("This id does not exist!");
                break;
            }
        }
    }

    public static Product findProductById(List<Product> products, int ID) {
        for(Product product : products) {
            if(product.getID() == ID) {
                return product;
            }
        }
        return null;
    }

    public static void productControl(List<Product> products, Scanner sc) {
        System.out.print("Enter the product id to update stock: ");
        int ID = sc.nextInt();
        sc.nextLine();
        Product productFound = findProductById(products, ID);

        if(productFound == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Do you want to remove or add to the stock? ( a / r ) ");
        char response = sc.nextLine().charAt(0);
        switch (response) {
            case'a':
                System.out.print("report the quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                productFound.addToStock(quantity);
                break;
            case 'r':
                System.out.print("report the quantity to remove: ");
                int quantityToRemove = sc.nextInt();
                sc.nextLine();
                productFound.removeToStock(quantityToRemove);
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.print("Do you want to apply discount? ( y / n ): ");
        char question = sc.nextLine().charAt(0);
        if(question == 'y') {
            System.out.print("Enter the percentage: ");
            int percentage = sc.nextInt();
            sc.nextLine();
            productFound.applyDiscount(percentage);
        }

        System.out.println("Do you want to increase price? ( y / n ): ");
        char questionPrice = sc.nextLine().charAt(0);
        if(questionPrice == 'y') {
            System.out.print("Enter the percentage: ");
            int percentage = sc.nextInt();
            sc.nextLine();
            productFound.increasePrice(percentage);
        }
    }
}
