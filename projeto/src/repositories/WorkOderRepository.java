package repositories;

import model.entities.WorkOrder;
import model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class WorkOderRepository {
    private Map<Integer, WorkOrder> orders = new LinkedHashMap<>();

    public void save(WorkOrder order) {
        orders.put(order.getId(), order);
    }

    public List<WorkOrder> findAll() {
        return new ArrayList<>(orders.values());
    }

    public WorkOrder findById(Integer Id) {
        return orders.get(Id);
    }

    public boolean existsById(Integer Id) {
        return orders.containsKey(Id);
    }
}
