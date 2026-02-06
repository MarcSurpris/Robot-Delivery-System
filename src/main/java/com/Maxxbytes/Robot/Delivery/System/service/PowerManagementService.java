package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Robot;

public interface PowerManagementService {

    void drainBattery(Robot robot, int percent);

    void chargeBattery(Robot robot, int percent);

    boolean isLowBattery(Robot robot);
}
