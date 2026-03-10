package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orderData = new ArrayList<>();

    public Order save(Order order) {
        for (int i = 0; i < orderData.size(); i++) {
            if (orderData.get(i).getId().equals(order.getId())) {
                orderData.set(i, order);
                return order;
            }
        }
        orderData.add(order);
        return order;
    }

    public Order findById(String id) {
        return orderData.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Order> findAllByAuthor(String author) {
        List<Order> results = new ArrayList<>();
        for (Order order : orderData) {
            if (order.getAuthor().equals(author)) {
                results.add(order);
            }
        }
        return results;
    }
}