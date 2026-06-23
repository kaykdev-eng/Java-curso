package atividade.model.repository;

import atividade.model.entities.WorkerOrder;

import java.util.List;

public interface WorkOrderRepository {
    public void save(WorkerOrder order);
    public List<WorkerOrder> findAll();
    public WorkerOrder findById(Integer id);
    public boolean existsById(Integer id);
}
