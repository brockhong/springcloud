package com.zhy.springboot;

import org.springframework.stereotype.Component;

@Component
public class FeignInterfaceImpl implements FeignInterface {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry feign "+name;
    }
}