package atividade.repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T> {
    List<T> list = new ArrayList<>();

    public void addToList (T value) {
        list.add(value);
    }

    public ArrayList<T> findAll() {
        if (list.isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        return new ArrayList<T>(list);
    }
}
