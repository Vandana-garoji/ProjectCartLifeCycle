package com.example.CartService.service;

import com.example.CartService.model.DeliveryDetails;
import com.example.CartService.model.OrderCompletion;
import com.example.CartService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderCompletionService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    int oId=0;
    public void validateAndPlaceOrder(int deliveryId) {
        DeliveryDetails deliveryDetails=restTemplate.getForObject("http://localhost:8081/getDeliveryDetailsById/"+ deliveryId ,DeliveryDetails.class);
        if(deliveryDetails.getPayment().equals("COD")  && !(deliveryDetails.getAddress().isBlank())){
            OrderCompletion orderCompletion = new OrderCompletion();
            orderCompletion.setOrderId(++oId);
            orderCompletion.setDeliveryDetails(deliveryDetails);
            orderRepository.save(orderCompletion);
        }
    }

    public List<OrderCompletion> getAllPlacedOrders() {
        return orderRepository.findAll();
    }
}
