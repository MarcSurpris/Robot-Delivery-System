package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Location;
import com.Maxxbytes.Robot.Delivery.System.model.Robot;

public interface NavigationService {



    long estimateEtaMinutes(Location from, Location to, Robot robot);


    void validatePedestrianSpeed(double mph);
}
