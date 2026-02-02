package com.Maxxbytes.Robot.Delivery.System.controller;

import com.Maxxbytes.Robot.Delivery.System.model.Location;
import com.Maxxbytes.Robot.Delivery.System.model.Robot;
import com.Maxxbytes.Robot.Delivery.System.service.NavigationService;
import com.Maxxbytes.Robot.Delivery.System.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robots")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping
    public Robot register(
            @RequestParam double speed,
            @RequestParam int batteryLevel) {
        return robotService.registerRobot(speed, batteryLevel);
    }

    @PostMapping("/assign")
    public Robot assign() {
        return robotService.assignAvailableRobot();
    }

    @GetMapping
    public List<Robot> all() {
        return robotService.getAllRobots();
    }

    @GetMapping("/{id}")
    public Robot one(@PathVariable Long id) {
        return robotService.getRobotById(id);
    }
}
