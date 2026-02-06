package com.Maxxbytes.Robot.Delivery.System.controller;

import com.Maxxbytes.Robot.Delivery.System.model.Location;
import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.service.NavigationService;
import com.Maxxbytes.Robot.Delivery.System.service.RobotService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/navigation")
public class NavigationController {

    private final NavigationService navigationService;
    private final RobotService robotService;

    public NavigationController(NavigationService navigationService, RobotService robotService) {
        this.navigationService = navigationService;
        this.robotService = robotService;
    }


    @GetMapping("/eta")
    public Map<String, Object> getEta(
            @RequestParam Long robotId,
            @RequestParam double fromX,
            @RequestParam double fromY,
            @RequestParam double toX,
            @RequestParam double toY
    ) {
        Robot robot = robotService.getRobotById(robotId);

        Location from = new Location(fromX, fromY);
        Location to = new Location(toX, toY);

        long etaMinutes = navigationService.estimateEtaMinutes(from, to, robot);


        boolean meetsDeliveryTimeConstraint = etaMinutes <= 10;

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("robotId", robotId);
        result.put("etaMinutes", etaMinutes);
        result.put("meetsDeliveryTimeConstraint", meetsDeliveryTimeConstraint);

        return result;
    }
}
