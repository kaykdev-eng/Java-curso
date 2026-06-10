package polimorfismo.entites;

public class OutsourcedEmployee extends Employee {
    private Double addicionalCharge;

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour,Double addicionalCharge) {
        super(name, hours, valuePerHour);
        this.addicionalCharge = addicionalCharge;
    }

    @Override
    public final Double payment() {
        return super.payment() + addicionalCharge * 1.10;
    }

    public Double getAddicionalCharge() {
        return addicionalCharge;
    }

    public void setAddicionalCharge(Double addicionalCharge) {
        this.addicionalCharge = addicionalCharge;
    }
}
