package com.sachin.eureka.eurekaserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient让该应用作为client 具有发现服务的能力
 */
@EnableCircuitBreaker //启用Hystrix功能
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){


        return new RestTemplate();

    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConsumerApplication.class, args);
    }

}
