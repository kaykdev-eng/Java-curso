package default_methods.entites;

import java.security.InvalidParameterException;

public class UsaInterestService implements InterestService {
    private Double interestRate;

    public UsaInterestService(Double amount) {
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
