package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.entity.Coupon;
import com.jeffry.springcloud.service.CouponService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couponapi")
@PropertySource("classpath:bootstrap.properties")
public class CouponController {

    private final CouponService couponService;
    private final Environment environment;

    private String serverPort;

    public CouponController(CouponService couponService, Environment environment) {
        this.couponService = couponService;
        this.environment = environment;
    }

    @GetMapping()
    public String test() {
        serverPort = environment.getProperty("server.port");
        System.out.println(">>>> SERVER: RUNNING ON [ PORT NO: " + serverPort + " ]");
        return "COUPON-SERVICE: UP AND RUNNING...[ON PORT: " + serverPort + "]";

    }

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody(required = true) Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @GetMapping("coupons/{code}")
    public Coupon getCoupon(@PathVariable(name = "code") String code) throws Exception {
        return couponService.getCoupon(code);
    }

    @GetMapping("/coupons")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }
    
}
