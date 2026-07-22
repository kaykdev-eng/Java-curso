package repository;

import java.util.List;

public class InventoryPrinter {
    public void print(List<?> list) {
        for(Object obj : list) {
            System.out.println(obj);
        }
    }
}
