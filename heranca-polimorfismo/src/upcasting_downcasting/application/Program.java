package upcasting_downcasting.application;

import upcasting_downcasting.entites.Account;
import upcasting_downcasting.entites.BussinessAccount;
import upcasting_downcasting.entites.SavingsAccount;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc = new Account(1001, "Kayk", 0.0);
        BussinessAccount bacc = new BussinessAccount(1002, "Eduarda", 0.0, 500.00);

        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BussinessAccount(1003, "Luciano", 100.0, 50.0);
        Account acc3 = new SavingsAccount(1004, "Izadora", 500.00, 0.2);

        // DOWNCASTING

        BussinessAccount acc4 = (BussinessAccount) acc2;
        acc4.loan(100.0);

        if(acc3 instanceof BussinessAccount) {
            BussinessAccount acc5 = (BussinessAccount) acc3;
            acc5.loan(100);
            System.out.println("LOAN!");
        }

        if(acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        sc.close();
    }
}
