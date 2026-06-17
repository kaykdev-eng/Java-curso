package atividade_final_modulo.entites;

import atividade_final_modulo.Enum.TypeDelivery;

public final class CommonDelivery extends Delivery{

    public CommonDelivery (Integer Id, String client, Double weightKg, Double basePrice, TypeDelivery statusDelivery) {
        super(Id, client, weightKg, basePrice, statusDelivery);
    }

    @Override
    public Double calculateShipping() {
        return super.basePriceCalc();
    }
}
