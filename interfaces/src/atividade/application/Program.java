package atividade.application;

import atividade.model.entities.EmergencyOrder;
import atividade.model.entities.InstallationOrder;
import atividade.model.entities.MaintenanceOrder;
import atividade.model.entities.WorkerOrder;
import atividade.model.enums.ServiceType;
import atividade.model.exceptions.DomainException;
import atividade.model.repository.InMemoryWorkOrderRepository;
import atividade.model.repository.WorkOrderRepository;
import atividade.model.service.BrazilTaxService;
import atividade.model.service.TaxService;
import atividade.model.service.UsTaxService;
import atividade.model.service.WorkOrderService;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        WorkOrderRepository repository = new InMemoryWorkOrderRepository();
        TaxService taxService;

        System.out.print("Tax country (b/u):");
        char response = sc.nextLine().charAt(0);
        if (response == 'b') {
            taxService = new BrazilTaxService();
        } else if (response == 'u') {
            taxService = new UsTaxService();;
        }else{
            throw new DomainException("Invalid tax country");
        }
        WorkOrderService service = new WorkOrderService(repository, taxService);

        System.out.print("How many work orders?");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            WorkerOrder order;
            try {
                System.out.printf("Work order #%d: %n", i + 1);
                System.out.print("Type (m/i/e): ");
                char responseType = sc.nextLine().charAt(0);

                System.out.print("ID: ");
                Integer id = sc.nextInt();
                sc.nextLine();

                System.out.print("Client: ");
                String client = sc.nextLine();

                System.out.print("Description: ");
                String description = sc.nextLine();

                System.out.print("Hours: ");
                Double hours = sc.nextDouble();

                System.out.print("Value per hour: ");
                Double valuePerHour = sc.nextDouble();
                sc.nextLine();

                switch (responseType) {
                    case 'm':
                        order = new MaintenanceOrder(id, client, description, hours, valuePerHour, ServiceType.MAINTENANCE);
                        service.register(order);
                        break;
                    case 'i':
                        System.out.print("Material cost: ");
                        Double materialCost = sc.nextDouble();
                        sc.nextLine();
                        order = new InstallationOrder(id, client, description, hours, valuePerHour, ServiceType.INSTALLATION, materialCost);
                        service.register(order);
                        break;
                    case 'e':
                        System.out.print("Emergency fee: ");
                        Double emergencyFee = sc.nextDouble();
                        sc.nextLine();
                        order = new EmergencyOrder(id, client, description, hours, valuePerHour, ServiceType.EMERGENCY, emergencyFee);
                        service.register(order);
                        break;
                    default:
                        throw new DomainException("Invalid service type");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (DomainException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        System.out.println("WORK ORDERS REPORT:");
        for (WorkerOrder or : repository.findAll()) {
            System.out.println(or);
        }

        System.out.println("TOTAL REVENUE: " + String.format("%.2f", service.totalRevenue()));

        sc.close();
    }
}
