package com.cloud.eurekaribbonclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Carol on 2018/12/6.
 * 在IoC容器中注入一个restTemplate的Bean， 并在这个Bean上加上@LoadBalanced注解，
 * 此时RestTemplate就结合了Ribbon开启了负载均衡功能
 */
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
