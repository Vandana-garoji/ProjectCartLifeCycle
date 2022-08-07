package com.example.CartService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DeliveryDetails")
public class DeliveryDetails {
    @Id
    private int deliveryId;
    private Cart cart;
    private String address;
    private long phNo;
    private String payment;
}
