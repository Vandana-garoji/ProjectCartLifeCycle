
package com.example.CartService.controller;

import com.example.CartService.model.DeliveryDetails;
import com.example.CartService.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/addDelivery/{cartId}")
    public void addDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails, @PathVariable int cartId){
        deliveryService.addDeliveryDetails(deliveryDetails,cartId);
    }

    @GetMapping("/getDeliveryDetailsById/{deliveryId}")
    public Optional<DeliveryDetails> getDeliveryDetailsById(@PathVariable int deliveryId){
        return deliveryService.getDeliveryDetailsById(deliveryId);
    }
}
