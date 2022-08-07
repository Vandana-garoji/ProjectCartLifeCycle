package com.example.CartService.repository;

import com.example.CartService.model.OrderCompletion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderCompletion,Integer> {
}
