package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.entity.Coupon;
import com.jeffry.springcloud.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couponapi")
@PropertySource("classpath:application.properties")
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
        int SERVER_NO = 3;
        serverPort = environment.getProperty("server.port");
        System.out.println(">>>> SERVER: " + SERVER_NO +" RUNNING ON port: " + serverPort);
        return "COUPON-SERVICE: UP AND RUNNING...: SERVER: " + SERVER_NO + "  ON PORT: " + serverPort;
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
