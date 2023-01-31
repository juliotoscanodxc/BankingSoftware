# Demo Banking Software with Spring Cloud
![image](https://user-images.githubusercontent.com/122044639/215730788-73db75b1-77bc-48d1-b235-aae25cbdcd83.png)

This project is a training result where I needed implement some microservices approachs. The idea was exercise some concepts about a microservices architecture such as Single resposability principle, share-nothing architecture, asynchronous message-passing and service discovery pattern. Futhermore, we covered tools presents in Spring cloud to implement discovery server, REST API's, client-side load balancing, circuit breakers, API gateways and external centralized configurations. The netflix package was a main focus in this training, implementing the tools to reach all these concepts.

The modules is built using spring boot framework and maven to manager the dependencies. The comunication between the modules is applying the services discovery and the security using API tokens.

# Requirements
* Java 8
* Maven 3.10.1
* Docker
* Spring Boot
* Eureka (Broker used to Discovery Server)
* Ribbon (Client-side load balance)
* Feign (Connector between Discovery services and load balance)
* Hystrix (Circuit break)
* Zuul (API gateway)
* Turbine (Aggregator streams of server-sent events)
* Zipkin (Distributed tracing system)
* H2
* OAuth2

# Installation
You need run the Config server allowing the applications find the configurations required to start. After that initialize eureka servers allowing find services. Finally you can run the services one by one. The ideia to test is send messages through the API gateway to have acess to services. For this project we are running the zipkin ina container separeted: 
```bash
docker container run -d -p 9411:9411 openzipkin/zipkin
```
