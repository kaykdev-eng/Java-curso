package model.entities;

import model.enums.ServiceType;

public class MaintenceOrder extends WorkOrder {
    public MaintenceOrder(Integer id, String client, Integer hours, Double valuePerHour, ServiceType type) {
        super(id, client, hours, valuePerHour, ServiceType.MAINTENANCE);
    }

    @Override
    public Double totalAmount() {
        return super.baseAmount();
    }
}
