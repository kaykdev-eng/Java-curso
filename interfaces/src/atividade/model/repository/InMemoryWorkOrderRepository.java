package atividade.model.repository;

import atividade.model.entities.WorkerOrder;

import java.util.*;

public class InMemoryWorkOrderRepository implements WorkOrderRepository {
    private Map<Integer, WorkerOrder> orders = new LinkedHashMap<>();

    @Override
    public void save(WorkerOrder order) {
        orders.put(order.getId(), order);
    }

    @Override
    public List<WorkerOrder> findAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public WorkerOrder findById(Integer id) {
        return orders.get(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return orders.containsKey(id);
    }
}
