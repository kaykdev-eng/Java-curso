package atividade_final_modulo.entites;

import atividade_final_modulo.Enum.TypeDelivery;

public final class ExpressDelivery extends Delivery{
    private Double emergencFee;

    public ExpressDelivery(Integer Id, String client, Double weightKg, Double basePrice, TypeDelivery statusDelivery, Double emergencFee) {
        super(Id, client, weightKg, basePrice, statusDelivery);
        this.emergencFee = emergencFee;
    }

    @Override
    public Double calculateShipping() {
        return super.basePriceCalc() + emergencFee;
    }
}
