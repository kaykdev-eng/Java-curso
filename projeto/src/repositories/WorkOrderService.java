package repositories;

import model.entities.WorkOrder;
import model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//@Service
public class WorkOrderService {
    private WorkOderRepository repository;

    public WorkOrderService(WorkOderRepository repository) {
        this.repository = repository;
    }

    public void resgister(WorkOrder order) {
        if(repository.existsById(order.getId())) {
            throw new DomainException("This ID already exists in the database.");
        }
        repository.save(order);
    }

    public List<WorkOrder> findAll() {
        List<WorkOrder> orders = repository.findAll();
        if(orders.isEmpty()) {
            throw new DomainException("No work orders registered");
        }
        return orders;
    }

    public WorkOrder findById(Integer Id) {
        WorkOrder orders = repository.findById(Id);
        if(orders == null) {
            throw new DomainException("Work order not found for ID: " + Id);
        }
        return orders;
    }

    public Double totalRevenue() {
        List<WorkOrder> orders = repository.findAll();
        Double totalSum = 0.0;
        if(orders.isEmpty()) {
            throw new DomainException("No work orders registered");
        }

        for(WorkOrder or : orders) {
            totalSum += or.totalAmount();
        }
        return totalSum;
    }

    public WorkOrder mostExpensiveOrder() {
        List<WorkOrder> orders = repository.findAll();
        if(orders.isEmpty()) {
            throw new DomainException("No woork orders registered");
        }
        return orders.stream().max(Comparator.comparingDouble(WorkOrder::totalAmount)).orElseThrow(() -> new DomainException("No work orders registered"));
    }

}
