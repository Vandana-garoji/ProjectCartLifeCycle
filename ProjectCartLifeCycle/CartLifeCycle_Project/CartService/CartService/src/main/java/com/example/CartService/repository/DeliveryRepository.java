package com.example.CartService.repository;

import com.example.CartService.model.DeliveryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends MongoRepository<DeliveryDetails,Integer> {
}
