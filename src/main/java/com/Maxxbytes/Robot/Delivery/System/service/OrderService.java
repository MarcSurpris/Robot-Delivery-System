package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Order;
import com.Maxxbytes.Robot.Delivery.System.model.OrderItem;
import java.time.LocalDateTime;
import java.util.List;

import java.util.List;

public interface OrderService {

    Order createOrder(Long userId, String deliveryAddress);

    void addItemToOrder(Long orderId, OrderItem item);

    void removeItemFromOrder(Long orderId, String itemName);

    void payForOrder(Long orderId);

    void cancelOrder(Long orderId);

    void updateOrderStatus(Long orderId, com.Maxxbytes.Robot.Delivery.System.model.OrderStatus status);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    List<Order> getOrdersForUser(Long userId);

    List<Order> searchOrdersByItem(Long userId, String itemName);

    List<Order> searchOrdersByDateRange(
            Long userId,
            LocalDateTime from,
            LocalDateTime to);
}
