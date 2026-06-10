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

    @Override
    public void withDraw(double amount) {
        super.withDraw(amount);
        balance -= 2.0;
    }

    public Double getLoanLimit() {
        return this.loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
      this.loanLimit = loanLimit;
    }
}
