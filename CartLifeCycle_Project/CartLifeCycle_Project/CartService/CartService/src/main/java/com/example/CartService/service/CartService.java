package com.example.CartService.service;
import com.example.CartService.model.Cart;
import com.example.CartService.model.Product;
import com.example.CartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private RestTemplate restTemplate;
    private Cart cart=new Cart();
    public int cId=0;

    public void addToCart(int productId){
        Product product=restTemplate.getForObject("http://localhost:8080/getProductById/"+productId, Product.class);
        cart.setCartId(++cId);
        cart.setProduct(product);
        cart.setQuantity(1);
        cartRepository.save(cart);
    }
    public List<Cart> getAllItems(){
        return cartRepository.findAll();
    }
    public Optional<Cart> getItemByCartId(int cartId) {
        return cartRepository.findById(cartId);
    }
    public void updateCartQuantity(Cart cart){
        cartRepository.save(cart);
    }

    public void deleteItem(int cartId){
        cartRepository.deleteById(cartId);
    }

}
