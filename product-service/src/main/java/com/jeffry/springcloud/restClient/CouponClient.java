package com.jeffry.springcloud.restClient;

import com.jeffry.springcloud.dto.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "COUPON-SERVICE")
//@RibbonClient(name = "COUPON-SERVICE") ribbon is inherited within zuul proxy server
//Changing the name attribute. so the request always go to the zuul proxy
@FeignClient(name = "zuul-api-gateway-server")
public interface CouponClient {
    //zuul with redirect reques to the coupon-server: zuul-Server/micro-service-name/uri
    String COUPON = "/coupon-service/coupons/couponapi"; //before zuul-> "/coupons/couponapi/"

    @GetMapping(COUPON + "/")
    String testCouponService();

    @GetMapping(COUPON + "/{code}" )
    Coupon getCoupon(@PathVariable(name = "code") String code);
}
