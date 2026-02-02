package com.Maxxbytes.Robot.Delivery.System.controller;

import com.Maxxbytes.Robot.Delivery.System.model.Delivery;
import com.Maxxbytes.Robot.Delivery.System.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/start")
    public Delivery start(
            @RequestParam Long orderId,
            @RequestParam Long robotId) {
        return deliveryService.startDelivery(orderId, robotId);
    }

    @PostMapping("/complete")
    public void complete(@RequestBody Delivery delivery) {
        deliveryService.completeDelivery(delivery);
    }
}
