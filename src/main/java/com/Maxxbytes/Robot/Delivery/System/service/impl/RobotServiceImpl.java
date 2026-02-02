package com.Maxxbytes.Robot.Delivery.System.service.impl;

import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.model.RobotStatus;
import com.Maxxbytes.Robot.Delivery.System.service.RobotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotServiceImpl implements RobotService {

    private final List<Robot> robots = new ArrayList<>();
    private long counter = 1;

    @Override
    public Robot registerRobot(double speed, int batteryLevel) {
        Robot robot = new Robot();
        robot.setId(counter++);
        robot.setSpeed(speed);
        robot.setBatteryLevel(batteryLevel);
        robot.setStatus(RobotStatus.AVAILABLE);

        robots.add(robot);
        return robot;
    }

    @Override
    public Robot assignAvailableRobot() {
        Robot robot = robots.stream()
                .filter(r -> r.getStatus() == RobotStatus.AVAILABLE)
                .filter(r -> r.getSpeed() <= 15)
                .filter(r -> r.getBatteryLevel() > 20)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No available robot"));

        robot.setStatus(RobotStatus.IN_TRANSIT);
        return robot;
    }

    @Override
    public void updateRobotStatus(Long robotId, RobotStatus status) {
        Robot robot = getRobotById(robotId);
        robot.setStatus(status);
    }

    @Override
    public Robot getRobotById(Long robotId) {
        return robots.stream()
                .filter(r -> r.getId().equals(robotId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Robot not found"));
    }

    @Override
    public List<Robot> getAllRobots() {
        return robots;
    }
}
