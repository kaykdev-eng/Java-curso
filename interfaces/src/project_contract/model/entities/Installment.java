package project_contract.model.entities;

import project_contract.model.service.OnlinePaymentService;

import java.time.LocalDate;

public class Installment extends Contract{
    private LocalDate dueDate;
    private Double amount;

    public Installment(Integer number, LocalDate date, Double totalValue, OnlinePaymentService onlinePaymentService, LocalDate dueDate, Double amount) {
        super(number, date, totalValue, onlinePaymentService);
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
