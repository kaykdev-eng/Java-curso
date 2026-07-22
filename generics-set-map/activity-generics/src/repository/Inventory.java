package repository;

import java.util.ArrayList;
import java.util.List;

public class Inventory <T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        if(!items.remove(item)) {
            throw new IllegalArgumentException("Item not found.");
        }

        items.remove(item);
    }

    public T first() {
        if(items.isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        return items.get(0);
    }

    public List<T> findAll() {
        if(items.isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        return new ArrayList<>(items);
    }
}
