package upcasting_downcasting.exercicio.entites;

public class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public String toString() {
        return "SavingsAccount{number=" + getNumber() + ", holder=" + getHolder() + ", balance=" + getBalance() + ", interestRate=" + getInterestRate() + "}" ;
    }
}
