package com.jeffry.springcloud.restClient;

import com.jeffry.springcloud.dto.Coupon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "COUPON-SERVICE")
@RibbonClient(name = "COUPON-SERVICE")
public interface CouponClient {

    String COUPON = "/coupons/couponapi/";

    @GetMapping(COUPON)
    String testCouponService();

    @GetMapping(COUPON + "/{code}" )
    Coupon getCoupon(@PathVariable(name = "code") String code);
}
