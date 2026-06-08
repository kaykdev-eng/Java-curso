package upcasting_downcasting.exercicio.entites;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit) {
            balance += amount;
        } else{
            System.out.println("Loan limit exceeded");
        }
    }

    public Double getLoanLimit() {
        return this.loanLimit;
    }

    public String toString() {
        return "BusinessAccount{number=" + getNumber() + ", " + "holder=" + getHolder() + ", " + "balance=" + getBalance() + ", loandLimit=" + getLoanLimit() + "}" ;
    }
}
