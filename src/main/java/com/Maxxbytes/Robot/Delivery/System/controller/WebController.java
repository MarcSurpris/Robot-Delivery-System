package com.Maxxbytes.Robot.Delivery.System.controller;

import com.Maxxbytes.Robot.Delivery.System.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    private final OrderService orderService;

    public WebController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "index";
    }

    @PostMapping("/orders/create")
    public String createOrder(@RequestParam String address) {


        orderService.createOrder(1L, address);

        return "redirect:/";


    }
}
