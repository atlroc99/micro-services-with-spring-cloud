# micro-services-with-spring-cloud

Branch :
  - Master: 
    - creates and configures and microservices
    - added spring cloud eureka discover client
    - enaled eureka client to be discovered by the eureka server [eureka server is in a different repo/ project]
    - added openFeign maven dependecy to use feignClient
    
 - FeignClient:
    - added Coupon Serivce rest client
    - annotate it with the @FeignClient
    - add GET and other method to call Coupon-Service APIs
    - add @EnableFeignClient at the application main class
    
 - Ribbon: load balancing on the client side
   - added maven dependency spring-cloud-starter-netflix-ribbon
   - Annotated the FeingCleint Interface with @EnableRibbon("SERVICE-ID/NAME")
   - launch multipe same client service (change the port number and the sysout in the controller)
   - send request to the method and see how the load / call is distributed among different services
 
 
