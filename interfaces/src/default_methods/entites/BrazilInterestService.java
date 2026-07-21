package default_methods.entites;

import java.security.InvalidParameterException;

public class BrazilInterestService implements InterestService {
    private Double interestRate;

    public BrazilInterestService(Double amount) {
        this.interestRate = amount;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double amount) {
        this.interestRate = amount;
    }
}
