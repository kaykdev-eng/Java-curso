package atividade.model.service;

public class BrazilTaxService implements TaxService{
    @Override
    public Double tax(Double amount) {
        if(amount <= 100) {
            return amount * 0.20;
        }
        return amount * 0.15;
    }
}
