package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.service.ProductService;
import com.jeffry.springcloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
     public Product getProduct(@PathVariable(value = "id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
