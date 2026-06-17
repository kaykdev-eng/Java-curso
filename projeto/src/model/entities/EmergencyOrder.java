package model.entities;

import model.enums.ServiceType;

public class EmergencyOrder extends WorkOrder{
    private Double emergencyFee;

    public EmergencyOrder(Integer id, String client, Integer hours, Double valuePerHour, ServiceType type, Double emergencyFee) {
        super(id, client, hours, valuePerHour, ServiceType.EMERGENCY);
        this.emergencyFee = emergencyFee;
    }

    @Override
    public Double totalAmount() {
        return super.baseAmount() + emergencyFee * 0.20;
    }

    public Double getEmergencyFee() {
        return emergencyFee;
    }
}
