package com.sachin.eureka.eurekaserviceconsumer.controller;

import com.sachin.eureka.eurekaserviceconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Sachin
 * @Date 2020/9/20
 **/
@RestController
public class ConsumerController {


    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        /*//使用RestTemplate时采用了服务名作为host
        String body = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
        */

        String body = helloService.helloService();

        return body;


    }

    @RequestMapping(value = "/testError")
    public String testError() {

        if (true)
            throw new RuntimeException();
        return "testError";
    }
}
