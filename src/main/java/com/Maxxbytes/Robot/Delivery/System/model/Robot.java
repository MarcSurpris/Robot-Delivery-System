package com.Maxxbytes.Robot.Delivery.System.model;

public class Robot {

    private Long id;
    private RobotStatus status;
    private double speed;
    private int batteryLevel;

    public Robot() {}

    public Robot(Long id, RobotStatus status, double speed, int batteryLevel) {
        this.id = id;
        this.status = status;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RobotStatus getStatus() {
        return status;
    }

    public void setStatus(RobotStatus status) {
        this.status = status;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
