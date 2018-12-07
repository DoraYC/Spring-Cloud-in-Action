package com.cloud.eurekafeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Carol on 2018/12/6.
 * FeignClient 注解来声明一个Feign Client,其中value 为远程调用其他服务的服务名，此处是"eureka-client"，
 * 该方法通过Feign来调用eureka-client服务的"/hi"接口
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
