package Exercicio_enums.entites;

import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private Double valuePerHour;
    private Integer hour;

    public HourContract(){}

    public HourContract(LocalDate date, Double valuePerHour, Integer hour) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hour = hour;
    }

    public double totalValue() {
        return this.valuePerHour * this.hour ;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
