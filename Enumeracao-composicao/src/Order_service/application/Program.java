package Order_service.application;

import Order_service.entities.Client;
import Order_service.entities.Enums.OrderStatus;
import Order_service.entities.Order;
import Order_service.entities.OrderItem;
import Order_service.entities.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");

        System.out.print("Name:");
        String clientName = sc.nextLine();

        System.out.print("Email:");
        String clientEmail = sc.nextLine();

        System.out.print("Birth day: DD/MM/YYYY: ");
        String clientBirthDay = sc.nextLine();
        LocalDate BirthdayFmt = LocalDate.parse(clientBirthDay, fmt);
        Client client = new Client( clientName, clientEmail, BirthdayFmt );

        System.out.print("Enter order status: ");
        String clientStatus = sc.nextLine();
        Order order = new Order( Instant.now(), OrderStatus.valueOf(clientStatus),client );
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter #%d item data:\n", i + 1);
            System.out.print("Product name:");
            String productName = sc.nextLine();

            System.out.print("Product price:");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity:");
            Integer productQuantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
