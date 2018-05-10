package com.zhy.springboot;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FeignClient(value = "service-hi") 默认
 * 改为 hystrix 必须添加
 * @EnableCircuitBreaker
 */

//@FeignClient(value = "service-hi")
@FeignClient(value = "service-hi",fallback = FeignInterfaceImpl.class)
@EnableCircuitBreaker
public interface FeignInterface {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
