# micro-services-with-spring-cloud

Branch 
  - master: 
    - creates and configures and microservices
    - added spring cloud eureka discover client
    - enaled eureka client to be discovered by the eureka server [eureka server is in a different repo/ project]
    - added openFeign maven dependecy to use feignClient
    
  -FeignClient:
    - added Coupon Serivce rest client
    - annotate it with the @FeignClient
    - add GET and other method to call Coupon-Service APIs
    - add @EnableFeignClient at the application main class
 
 
