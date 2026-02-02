package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Order;
import com.Maxxbytes.Robot.Delivery.System.model.OrderItem;

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
}
