package com.example.CartService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "OrderDetails")
public class OrderCompletion
{
    @Id
    private int orderId;
    private DeliveryDetails deliveryDetails;
}
