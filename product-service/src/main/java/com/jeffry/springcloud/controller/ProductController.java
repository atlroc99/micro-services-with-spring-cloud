package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.service.ProductService;
import com.jeffry.springcloud.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    private String test() {
        return "PRODUCT-SERVICE: Up and running...";
    }

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

    @GetMapping("/testCoupon")
    @HystrixCommand(fallbackMethod = "sendErrorResponse")
    public String testCouponService() {
        return productService.testCouponService();
    }

    public String sendErrorResponse() {
        return "MESSAGE: FALLBACK ON THIS METHOD...COUPON SERVICE IS DOWN";
    }
}
