package atividade_construtores.application;

import atividade_construtores.entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        BankAccount bankAccount;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String titularName = sc.nextLine();

        System.out.print("Is there na initial deposit (y/n)? ");
        char response = sc.next().charAt(0);

        if( response == 'y' ) {
            System.out.print("Enter a deposit value: ");
            double initialDeposit = sc.nextDouble();
            bankAccount = new BankAccount(accountNumber, titularName, initialDeposit);
        } else {
            bankAccount = new BankAccount(accountNumber, titularName);
        }
        System.out.printf("Account data: %n%s%n",bankAccount);

        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        bankAccount.deposit(depositValue);
        System.out.printf("Updated account data: %n%s%n",bankAccount);

        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        bankAccount.withDraw(withdrawValue);
        System.out.printf("Updated account data: %n%s%n",bankAccount);



        sc.close();
    }
}
