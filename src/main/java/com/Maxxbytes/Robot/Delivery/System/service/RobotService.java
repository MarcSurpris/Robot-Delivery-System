package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.model.RobotStatus;

import java.util.List;

public interface RobotService {

    Robot registerRobot(double speed, int batteryLevel);

    Robot assignAvailableRobot();

    void updateRobotStatus(Long robotId, RobotStatus status);

    Robot getRobotById(Long robotId);

    List<Robot> getAllRobots();
}
