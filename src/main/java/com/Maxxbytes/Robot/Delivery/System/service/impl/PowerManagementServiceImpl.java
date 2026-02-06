package com.Maxxbytes.Robot.Delivery.System.service.impl;

import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.service.PowerManagementService;
import org.springframework.stereotype.Service;

@Service
public class PowerManagementServiceImpl implements PowerManagementService {

    private static final int LOW_BATTERY_THRESHOLD = 20;

    @Override
    public void drainBattery(Robot robot, int percent) {
        if (robot == null) {
            throw new IllegalArgumentException("Robot cannot be null");
        }
        if (percent < 0) {
            throw new IllegalArgumentException("Percent must be >= 0");
        }

        int newLevel = robot.getBatteryLevel() - percent;
        if (newLevel < 0) {
            newLevel = 0;
        }
        robot.setBatteryLevel(newLevel);
    }

    @Override
    public void chargeBattery(Robot robot, int percent) {
        if (robot == null) {
            throw new IllegalArgumentException("Robot cannot be null");
        }
        if (percent < 0) {
            throw new IllegalArgumentException("Percent must be >= 0");
        }

        int newLevel = robot.getBatteryLevel() + percent;
        if (newLevel > 100) {
            newLevel = 100;
        }
        robot.setBatteryLevel(newLevel);
    }

    @Override
    public boolean isLowBattery(Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("Robot cannot be null");
        }
        return robot.getBatteryLevel() <= LOW_BATTERY_THRESHOLD;
    }
}
