package com.Maxxbytes.Robot.Delivery.System.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Long userId;
    private OrderStatus status;
    private LocalDateTime createdTime;
    private List<OrderItem> items = new ArrayList<>();
    private String deliveryAddress;
    private double totalCost;
    private boolean paid;

    public Order() {}

    public Order(Long id, Long userId, String deliveryAddress) {
        this.id = id;
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
        this.status = OrderStatus.PLACED;
        this.createdTime = LocalDateTime.now();
        this.totalCost = 0.0;
        this.paid = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}
