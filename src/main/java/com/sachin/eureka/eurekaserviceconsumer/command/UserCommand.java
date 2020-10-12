package com.sachin.eureka.eurekaserviceconsumer.command;

import com.netflix.hystrix.HystrixCommand;
import com.sachin.entity.User;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Sachin
 * @Date 2020/10/12
 **/
public class UserCommand  extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private Long id ;

    protected UserCommand(Setter setter, RestTemplate restTemplate,Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://user-service/users/{1}", User.class, id);
    }
}
