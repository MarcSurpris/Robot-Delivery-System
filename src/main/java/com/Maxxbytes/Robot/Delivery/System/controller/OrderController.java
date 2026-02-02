package com.Maxxbytes.Robot.Delivery.System.controller;

import com.Maxxbytes.Robot.Delivery.System.model.Order;
import com.Maxxbytes.Robot.Delivery.System.model.OrderItem;
import com.Maxxbytes.Robot.Delivery.System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(
            @RequestParam Long userId,
            @RequestParam String address) {
        return orderService.createOrder(userId, address);
    }

    @PostMapping("/{id}/items")
    public void addItem(
            @PathVariable Long id,
            @RequestBody OrderItem item) {
        orderService.addItemToOrder(id, item);
    }

    @PostMapping("/{id}/pay")
    public void pay(@PathVariable Long id) {
        orderService.payForOrder(id);
    }

    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

    @GetMapping
    public List<Order> allOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOne(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}