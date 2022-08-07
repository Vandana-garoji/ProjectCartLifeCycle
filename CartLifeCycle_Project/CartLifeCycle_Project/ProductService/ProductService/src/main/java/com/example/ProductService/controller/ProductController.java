package com.example.ProductService.controller;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PostMapping("/addProduct")
    public String saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Added product with id: "+ product.getProductId();
    }
    @PutMapping("/updateProduct/")
    public String updateProduct(@RequestBody Product product){
        productRepository.save(product);
        return "product updated";
    }
    @GetMapping("/getAllProductsInStore")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/getProductById/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId){
        return productRepository.findById(productId);
    }


    @DeleteMapping("/delete/{productId}")
    public String deleteEmployee(@PathVariable int productId){
        productRepository.deleteById(productId);
        return "product deleted with id :"+ productId;
    }


}
