package polimorfismo.application;

import polimorfismo.entites.Employee;
import polimorfismo.entites.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employeers: ");
        int n = sc.nextInt();
        char response;
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.printf("Employee #%d data:%n", i + 1 );
            System.out.print("Outsourced (y/n)?");
            response = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours: ");
            Integer hour = sc.nextInt();

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            sc.nextLine();
            if(response == 'n') {
                Employee employee = new Employee(name, hour, valuePerHour);
                employees.add(employee);
            } else if(response == 'y') {
                System.out.print("Addicional charge: ");
                Double addicionalCharge = sc.nextDouble();
                sc.nextLine();

                Employee employee = new OutsourcedEmployee(name, hour, valuePerHour, addicionalCharge);
                employees.add(employee);
            }
        }

        for(Employee emp : employees) {
            System.out.printf("%s - $ %.2f%n", emp.getName(), emp.payment());
        }

        sc.close();
    }
}
