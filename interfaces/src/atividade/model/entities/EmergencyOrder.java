package atividade.model.entities;

import atividade.model.enums.ServiceType;

public class EmergencyOrder extends WorkerOrder {
    private Double emergencyFee;

    public EmergencyOrder(Integer id, String client, String description, Double hours, Double valuePerHour, ServiceType type, Double emergencyFee) {
        super(id, client, description, hours, valuePerHour, type);
        this.emergencyFee = emergencyFee;
    }

    @Override
    public Double serviceAmount() {
        return super.baseAmount() + emergencyFee + super.baseAmount() * 0.20;
    }

    public Double getEmergencyFee() {
        return emergencyFee;
    }

    public void setEmergencyFee(Double emergencyFee) {
        this.emergencyFee = emergencyFee;
    }
}
