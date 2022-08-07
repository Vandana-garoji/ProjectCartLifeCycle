package com.example.CartService.controller;

import com.example.CartService.model.OrderCompletion;
import com.example.CartService.service.OrderCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderCompletionController {
    @Autowired
    private OrderCompletionService orderCompletionService;

    @PostMapping("/validateAndPlaceOrder/{deliveryId}")
    public void validateAndPlaceOrder(@PathVariable int deliveryId){
        orderCompletionService.validateAndPlaceOrder(deliveryId);
    }
    @GetMapping("/getAllPlacedOrders")
    public List<OrderCompletion> getAllPlacedOrders(){
        return orderCompletionService.getAllPlacedOrders();
    }
}
