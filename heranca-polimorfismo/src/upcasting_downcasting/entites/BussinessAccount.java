package upcasting_downcasting.entites;

public class BussinessAccount extends Account {
    private Double loanLimit;

    public BussinessAccount(Integer number, String holder, Double balance, Double loandLimit) {
        super(number, holder, balance);
        this.loanLimit = loandLimit;
    }

    public void loan(double amount) {
        if(loanLimit <= amount) {
            balance += amount;
        }
    }

    public Double getLoanLimit() {
        return this.loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
      this.loanLimit = loanLimit;
    }
}
