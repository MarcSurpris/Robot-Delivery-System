package com.Maxxbytes.Robot.Delivery.System.service.impl;

import com.Maxxbytes.Robot.Delivery.System.model.Order;
import com.Maxxbytes.Robot.Delivery.System.repository.OrderRepository;
import com.Maxxbytes.Robot.Delivery.System.model.OrderItem;
import com.Maxxbytes.Robot.Delivery.System.model.OrderStatus;
import com.Maxxbytes.Robot.Delivery.System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class OrderServiceImpl implements OrderService {
    private final List<Order> orders = new ArrayList<>();
    private long counter = 1;

    @Override
    public Order createOrder(Long userId, String deliveryAddress) {
        Order order = new Order(counter++, userId, deliveryAddress);
        orders.add(order);
        return order;
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        order.setStatus(status);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Override
    public void addItemToOrder(Long orderId, OrderItem item) {
        Order order = getOrderById(orderId);

        if (order.getStatus() != OrderStatus.PLACED) {
            throw new IllegalStateException("Cannot modify order after confirmation");
        }

        if (item.getPrice() <= 0 || item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid item price or quantity");
        }

        order.getItems().add(item);
        recalcTotal(order);
    }

    @Override
    public void removeItemFromOrder(Long orderId, String itemName) {
        Order order = getOrderById(orderId);

        if (order.getStatus() != OrderStatus.PLACED) {
            throw new IllegalStateException("Cannot modify order after confirmation");
        }

        order.getItems().removeIf(i -> i.getName().equalsIgnoreCase(itemName));
        recalcTotal(order);
    }

    private void recalcTotal(Order order) {
        double total = 0.0;

        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        order.setTotalCost(total);
    }

    @Override
    public void payForOrder(Long orderId) {
        Order order = getOrderById(orderId);

        if (order.isPaid()) {
            throw new IllegalStateException("Order already paid");
        }

        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot pay for empty order");
        }

        order.setPaid(true);
        order.setStatus(OrderStatus.CONFIRMED);
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order order = getOrderById(orderId);

        if (order.getStatus() != OrderStatus.PLACED) {
            throw new IllegalStateException("Order cannot be cancelled now");
        }

        order.setStatus(OrderStatus.CANCELLED);
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
}