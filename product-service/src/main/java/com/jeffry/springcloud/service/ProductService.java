package com.jeffry.springcloud.service;

import com.jeffry.springcloud.dto.Coupon;

import com.jeffry.springcloud.repository.ProductRepository;
import com.jeffry.springcloud.restClient.CouponClient;
import lombok.extern.slf4j.Slf4j;
import com.jeffry.springcloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@PropertySource("classpath:application.properties")
public class ProductService {

    private ProductRepository productRepository;
    private CouponClient couponClient;

    @Value("${coupon.api}")
    private String api;
    @Value("${coupon.contextPath}")
    private String contextPath;

    @Autowired
    public ProductService(ProductRepository productRepository, CouponClient couponClient){
        this.productRepository = productRepository;
        this.couponClient = couponClient;
    }

    public String testCouponService() {
        log.info(">>>>> Testing coupon service: " + contextPath + "/" + api + "/");
        return couponClient.testCouponService();
    }

    @Transactional
    public Product createProduct(Product product) {
        log.info(">>> fetch coupon code: " + couponClient+ "/" + product.getCouponCode());
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
         return productRepository.save(product);
    }
    
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
