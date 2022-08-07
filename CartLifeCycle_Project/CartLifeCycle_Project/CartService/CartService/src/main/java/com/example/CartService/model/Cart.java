package com.example.CartService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CartDbCollection")
public class Cart {
  @Id
  private  int cartId;
  private Product product;
  private int quantity;
}
