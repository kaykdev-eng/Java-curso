package Exercicio_enums.application;

import Exercicio_enums.entites.Department;
import Exercicio_enums.entites.HourContract;
import Exercicio_enums.entites.Worker;
import Exercicio_enums.entites.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();
        System.out.println("Enter the work data");
        System.out.print("Name: ");
        String Workername = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(Workername, baseSalary, WorkerLevel.valueOf(workerLevel), new Department(departamentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        sc.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the contract #%d data:", i + 1);

            System.out.print("DATE (DD/MM/YYYY): ");
            String date = sc.nextLine();

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            System.out.println("Duration (hour): ");
            Integer hour = sc.nextInt();
            sc.nextLine();
            LocalDate contractDate = LocalDate.parse(date, fmt);

            HourContract contract = new HourContract(contractDate, valuePerHour, hour);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.printf("Income for %d/%d: %.2f", month, year, worker.income(year, month));

        sc.close();
    }
}
