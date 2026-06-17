package atividade_final_modulo.application;

import atividade_final_modulo.Enum.TypeDelivery;
import atividade_final_modulo.entites.CommonDelivery;
import atividade_final_modulo.entites.Delivery;
import atividade_final_modulo.entites.ExpressDelivery;
import atividade_final_modulo.entites.InternationalDelivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Delivery delivery;
        List<Delivery> deliveries = new ArrayList<>();

        System.out.print("Enter the number of deliveries: ");
        int nod = sc.nextInt();
        sc.nextLine();
        char response;

        for (int i = 0; i < nod; i++) {
            System.out.printf("Delivery #%d data: %n", i + 1);
            System.out.print("Commom, express or international (c/e/i)?: ");
            response = sc.nextLine().charAt(0);
            System.out.print("Code: ");
            Integer id = sc.nextInt();
            sc.nextLine();

            System.out.print("Client: ");
            String client = sc.nextLine();

            System.out.print("Weight (Kg): ");
            Double weightKg = sc.nextDouble();

            System.out.print("Base price:");
            Double basePrice = sc.nextDouble();
            sc.nextLine();

            switch (response) {
                case 'c'  :
                    delivery = new CommonDelivery(id, client, weightKg, basePrice, TypeDelivery.COMMON_DELIVERY);
                    deliveries.add(delivery);
                    break;

                case 'e' :
                    System.out.print("Urgency fee: ");
                    Double urgencyFee = sc.nextDouble();
                    sc.nextLine();

                    delivery = new ExpressDelivery(id, client, weightKg, basePrice, TypeDelivery.EXPRESS_DELIVERY, urgencyFee);
                    deliveries.add(delivery);
                    break;

                case 'i' :
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();

                    System.out.println("Insurance: ");
                    Double insuarence = sc.nextDouble();

                    delivery = new InternationalDelivery(id, client, weightKg, basePrice, TypeDelivery.INTERNATIONAL_DELIVERY, customsFee, insuarence);
                    deliveries.add(delivery);
                    break;
                default:
                    System.out.println("Enter some type of delivery!");
                    break;
            }
        }

        Double total = 0.0;
        System.out.println("DELIVERY REPORT:");
        for (Delivery del : deliveries) {
            System.out.println(del.toString());
            total += del.calculateShipping();
        }
        System.out.printf("TOTAL FREIGHT $ %.2f%n", total);

        sc.close();
    }
}
