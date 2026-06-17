package application;

import model.entities.EmergencyOrder;
import model.entities.InstallationOrder;
import model.entities.MaintenceOrder;
import model.entities.WorkOrder;
import model.enums.ServiceType;
import model.exceptions.DomainException;
import repositories.WorkOderRepository;
import repositories.WorkOrderService;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        WorkOderRepository repository = new WorkOderRepository();
        WorkOrderService service = new WorkOrderService(repository);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of work orders: ");
        int n = sc.nextInt();
        char response;
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.printf("Worker order #%d:%n", i + 1);
                System.out.print("Type (m/i/e): ");
                response = sc.nextLine().charAt(0);
                while (response != 'm' && response != 'i' && response != 'e') {
                    System.out.println("Enter the righ type (m/i/e): ");
                    response = sc.nextLine().charAt(0);
                }

                System.out.print("Id: ");
                Integer Id = sc.nextInt();
                sc.nextLine();

                System.out.print("Client: ");
                String client = sc.nextLine();

                System.out.print("Hour: ");
                Integer hour = sc.nextInt();
                sc.nextLine();

                System.out.print("Value per hour: ");
                Double valuePerHour = sc.nextDouble();
                sc.nextLine();
                switch (response) {
                    case 'm':
                        WorkOrder maintenceOrder = new MaintenceOrder(Id, client, hour, valuePerHour, ServiceType.MAINTENANCE);
                        service.resgister(maintenceOrder);
                        break;
                    case 'i':
                        System.out.print("Material cost: ");
                        Double materialCost = sc.nextDouble();
                        sc.nextLine();

                        WorkOrder installationOrder = new InstallationOrder(Id, client, hour, valuePerHour, ServiceType.INSTALLATION, materialCost);
                        service.resgister(installationOrder);
                        break;
                    case 'e':
                        System.out.print("Emergency fee: ");
                        Double emergenceFee = sc.nextDouble();
                        sc.nextLine();

                        WorkOrder emergencyOrder = new EmergencyOrder(Id, client, hour, valuePerHour, ServiceType.EMERGENCY, emergenceFee);
                        service.resgister(emergencyOrder);
                        break;
                    default:
                        System.out.println("Enter the correctly type!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number: " + e.getMessage());
                sc.nextLine();
                i--;
            } catch (DomainException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        System.out.println("WORK ORDERS REPORT:");
        for (WorkOrder or : service.findAll()) {
            System.out.println(or);
        }
        System.out.printf("TOTAL REVENUE: $ %.2f%n", service.totalRevenue());

        System.out.println("MOST EXPENSIVE ORDER:");
        WorkOrder expensiveOrder = service.mostExpensiveOrder();
        System.out.println(expensiveOrder);

        System.out.print("Enter an ID to search: ");
        try {
            int searchId = sc.nextInt();
            WorkOrder order = service.findById(searchId);
            System.out.println(order);
        } catch (InputMismatchException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (DomainException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        sc.close();
    }
}
