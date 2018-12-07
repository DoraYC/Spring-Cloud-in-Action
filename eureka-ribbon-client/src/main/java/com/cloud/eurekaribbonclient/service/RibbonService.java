package com.cloud.eurekaribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Carol on 2018/12/6.
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 用restTemplate 调用 eureka-client的API接口
     * @param name
     * @return
     */
    public String hi(String name){
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
}
