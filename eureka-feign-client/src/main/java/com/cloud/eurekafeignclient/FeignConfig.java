package com.cloud.eurekafeignclient;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Carol on 2018/12/6.
 */
@Configuration
public class FeignConfig {
    @Bean //注入该Bean 后Feign在远程调用失败后会进行重试，重试间隔为100毫秒，最大重试时间为1秒，重试次数为5次
    public Retryer feignRetryer(){
        return new Retryer.Default(100, SECONDS.toMillis(1),5);
    }
}
