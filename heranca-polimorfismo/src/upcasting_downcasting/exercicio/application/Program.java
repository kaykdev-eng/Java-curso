package upcasting_downcasting.exercicio.application;

import upcasting_downcasting.exercicio.entites.Account;
import upcasting_downcasting.exercicio.entites.BusinessAccount;
import upcasting_downcasting.exercicio.entites.SavingsAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Account acc = new Account(1001, "Kayk", 1100.0);
        Account bacc = new BusinessAccount(1002, "Eduarda", 1300.0, 500.0);
        Account sacc = new SavingsAccount(1003, "Luciano", 1212.0, 0.01);
        Collections.addAll(accounts, acc, bacc, sacc);

        for(Account ac : accounts) {
            ac.deposit(100.0);
            ac.withdraw(50.0);
            if(ac instanceof BusinessAccount) {
                ((BusinessAccount) ac).loan(200.0);
                System.out.println("EMPRESTIMO REALIZADO NA CONTA EMPRESARIAL!");
            } else if(ac instanceof SavingsAccount) {
                ((SavingsAccount) ac).updateBalance();
                System.out.println("SALDO ATUALIZADO COM JUROS NA CONTA POUPANÇA!");
            }
        }
        for(Account ac : accounts) {
            System.out.println(ac);
        }
    }
}
