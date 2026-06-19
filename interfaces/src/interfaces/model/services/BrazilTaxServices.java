package interfaces.model.services;

public class BrazilTaxServices implements TaxService {
    @Override
    public double tax(double amount) {
        if(amount <= 100) {
            return amount * 0.2;
        }
        return amount * 0.15;
    }


}
