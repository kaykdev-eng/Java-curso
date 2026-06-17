package atividade_final_modulo.entites;

import atividade_final_modulo.Enum.TypeDelivery;

public final class InternationalDelivery extends Delivery{
    private Double customsFee;
    private Double insurance;

    public InternationalDelivery (Integer Id, String client, Double weightKg, Double basePrice, TypeDelivery statusDelivery, Double customsFee, Double insurance) {
        super(Id, client, weightKg, basePrice, statusDelivery);
        this.customsFee = customsFee;
        this.insurance = insurance;
    }

    @Override
    public Double calculateShipping () {
        return super.basePriceCalc() + customsFee + insurance;
    }
}
