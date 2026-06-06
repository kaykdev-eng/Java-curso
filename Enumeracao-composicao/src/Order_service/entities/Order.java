package Order_service.entities;

import Order_service.entities.Enums.OrderStatus;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Instant moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(){}

    public Order(Instant moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public Double total() {
        double sum = 0;
        for(OrderItem or : orderItems) {
            sum += or.subTotal();
        }
        return sum;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("Order Moment: ");
        sb.append(getMoment());
        sb.append("\nOrder status: ");
        sb.append(getStatus());
        sb.append("\nClient: ");
        sb.append(client.getName());
        sb.append(" (");
        sb.append(client.getBirthDate().format(fmt));
        sb.append(") - ");
        sb.append(client.getEmail());
        sb.append("\nOrder items:");
        for (OrderItem or : orderItems) {
            sb.append(or.getProduct().getName());
            sb.append(", $");
            sb.append(or.getProduct().getPrice());
            sb.append(", Quantity: ");
            sb.append(or.getQuantity());
            sb.append(", Subtotal: $");
            sb.append(or.subTotal());
            sb.append("\n");
        }
        sb.append("\nTotal Price: $");
        sb.append(total());
        return sb.toString();
    }
}

