package com.example.CartService.service;

import com.example.CartService.model.Cart;
import com.example.CartService.model.DeliveryDetails;
import com.example.CartService.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private RestTemplate restTemplate;
    int aId=0;
    public void addDeliveryDetails(DeliveryDetails deliveryDetails,int cartId) {
        Cart cart=restTemplate.getForObject("http://localhost:8081/getItemByCartId/"+ cartId ,Cart.class);
        deliveryDetails.setDeliveryId(++aId);
        deliveryDetails.setCart(cart);
        deliveryRepository.save(deliveryDetails);
    }
    public Optional<DeliveryDetails> getDeliveryDetailsById(int deliveryId) {
        return deliveryRepository.findById(deliveryId);
    }
}
