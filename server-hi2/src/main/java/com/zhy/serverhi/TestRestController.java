package com.zhy.serverhi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Value("${server.port}")
    String port;
    @RequestMapping("/hia")
    public String home(@RequestParam String name) {
        System.out.println("hia "+name+",i am from port:" +port);
        return "hia "+name+",i am from port:" +port;
    }
}
