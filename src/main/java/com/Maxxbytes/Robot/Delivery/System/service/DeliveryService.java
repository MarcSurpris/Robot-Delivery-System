package com.Maxxbytes.Robot.Delivery.System.service;

import com.Maxxbytes.Robot.Delivery.System.model.Delivery;

public interface DeliveryService {

    Delivery startDelivery(Long orderId, Long robotId);

    void completeDelivery(Delivery delivery);
}
