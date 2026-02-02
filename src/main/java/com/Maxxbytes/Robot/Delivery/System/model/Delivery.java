package com.Maxxbytes.Robot.Delivery.System.model;

import java.time.LocalDateTime;

public class Delivery {

    private Long orderId;
    private Long robotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Delivery() {}

    public Delivery(Long orderId, Long robotId, LocalDateTime startTime, LocalDateTime endTime) {
        this.orderId = orderId;
        this.robotId = robotId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRobotId() {
        return robotId;
    }

    public void setRobotId(Long robotId) {
        this.robotId = robotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
