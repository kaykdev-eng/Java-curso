package atividade.model.service;

import atividade.model.entities.Invoice;
import atividade.model.entities.WorkerOrder;
import atividade.model.exceptions.DomainException;
import atividade.model.repository.WorkOrderRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderService {
    private WorkOrderRepository repository;
    private TaxService taxService;

    public WorkOrderService(WorkOrderRepository repository, TaxService taxService) {
        this.repository = repository;
        this.taxService = taxService;
    }

    public void register(WorkerOrder order) {
        if(repository.existsById(order.getId())) {
           throw new DomainException("Work order ID already exists");
        }
        repository.save(order);
        processingInvoice(order);
    }

    public void processingInvoice(WorkerOrder order) {
        Double basicPayment = order.serviceAmount();
        Double tax = taxService.tax(basicPayment);

        order.setInvoice(new Invoice(tax, basicPayment));
    }

    public Double totalRevenue() {
        List<WorkerOrder> orders = new ArrayList<>(repository.findAll());
        Double total = 0.0;
        for (WorkerOrder or : orders) {
            total += or.getInvoice().getTotalPayment();
        }
        return total;
    }
}
