package atividade.model.service;

public class UsTaxService implements TaxService{
    @Override
    public Double tax(Double amount) {
        return amount * 0.10;
    }
}
