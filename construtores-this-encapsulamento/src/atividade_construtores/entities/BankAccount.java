package atividade_construtores.entities;

public class BankAccount {
    private final int accountNumber;
    private String titularName;
    private double balance;

    public BankAccount(int accountNumber, String titularName, double initialDeposit){
        this.accountNumber = accountNumber;
        this.titularName = titularName;
        deposit(initialDeposit);
    }

    public BankAccount (int accountNumber, String titularName) {
        this.accountNumber = accountNumber;
        this.titularName = titularName;
    }

    public String getTitularName() {
        return this.titularName;
    }

    public void setTitularName(String titularName) {
        this.titularName = titularName;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public void withDraw(double amount) {
        this.balance -= amount + 5.00;
    }

    public String toString() {
        return "Account " +
                getAccountNumber() +
                ", " +
                "Holder: " +
                getTitularName() +
                ", " +
                "Balance: $ " +
                String.format("%.2f", getBalance());


    }
}
