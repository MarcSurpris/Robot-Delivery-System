package com.Maxxbytes.Robot.Delivery.System.service.impl;

import com.Maxxbytes.Robot.Delivery.System.model.Location;
import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.service.NavigationService;
import com.Maxxbytes.Robot.Delivery.System.util.NavigationUtil;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Override
    public long estimateEtaMinutes(Location from, Location to, Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("Robot cannot be null");
        }

        validatePedestrianSpeed(robot.getSpeed());
        return NavigationUtil.etaMinutes(from, to, robot.getSpeed());
    }

    @Override
    public void validatePedestrianSpeed(double mph) {
        // Major business constraint: robots may not travel more than 15 mph on pedestrian walkways.
        if (mph > 15.0) {
            throw new IllegalArgumentException("Robot speed exceeds pedestrian walkway limit (15 mph).");
        }
        if (mph <= 0.0) {
            throw new IllegalArgumentException("Robot speed must be greater than 0.");
        }
    }
}
