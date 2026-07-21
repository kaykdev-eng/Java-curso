package project_contract.model.entities;

import project_contract.model.service.OnlinePaymentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalValue;

    OnlinePaymentService onlinePaymentService;
    List<Installment> installment;

    public Contract(Integer number, LocalDate date, Double totalValue, OnlinePaymentService onlinePaymentService) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
        this.onlinePaymentService = onlinePaymentService;
        this.installment = new ArrayList<>();

    }

    public Integer getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallment() {
        return installment;
    }

    public void addInstallment(Installment installment) {
        this.installment.add(installment);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        for (Installment installment : installment) {
            sb.append(installment.getDueDate().format(fmt))
                    .append(" - ")
                    .append(String.format("%.2f", installment.getAmount()))
                    .append("\n");
        }
        return sb.toString();

    }
}
