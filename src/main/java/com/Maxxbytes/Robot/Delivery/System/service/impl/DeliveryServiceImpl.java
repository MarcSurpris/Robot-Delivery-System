package com.Maxxbytes.Robot.Delivery.System.service.impl;

import com.Maxxbytes.Robot.Delivery.System.model.Delivery;
import com.Maxxbytes.Robot.Delivery.System.model.OrderStatus;
import com.Maxxbytes.Robot.Delivery.System.model.RobotStatus;
import com.Maxxbytes.Robot.Delivery.System.service.DeliveryService;
import com.Maxxbytes.Robot.Delivery.System.service.OrderService;
import com.Maxxbytes.Robot.Delivery.System.service.RobotService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final OrderService orderService;
    private final RobotService robotService;

    public DeliveryServiceImpl(OrderService orderService, RobotService robotService) {
        this.orderService = orderService;
        this.robotService = robotService;
    }

    @Override
    public Delivery startDelivery(Long orderId, Long robotId) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setRobotId(robotId);
        delivery.setStartTime(LocalDateTime.now());

        orderService.updateOrderStatus(orderId, OrderStatus.IN_TRANSIT);
        robotService.updateRobotStatus(robotId, RobotStatus.IN_TRANSIT);

        return delivery;
    }

    @Override
    public void completeDelivery(Delivery delivery) {
        delivery.setEndTime(LocalDateTime.now());

        long minutes = Duration.between(
                delivery.getStartTime(),
                delivery.getEndTime()
        ).toMinutes();

        if (minutes <= 10) {
            orderService.updateOrderStatus(
                    delivery.getOrderId(),
                    OrderStatus.DELIVERED
            );
        } else {
            orderService.updateOrderStatus(
                    delivery.getOrderId(),
                    OrderStatus.FAILED
            );
        }

        robotService.updateRobotStatus(
                delivery.getRobotId(),
                RobotStatus.AVAILABLE
        );
    }
}
