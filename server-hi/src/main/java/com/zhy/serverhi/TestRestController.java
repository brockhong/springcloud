package com.zhy.serverhi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRestController {

    private static final Logger LOG = Logger.getLogger(ServerHiApplication.class.getName());


    @Value("${server.port}")
    String port;
    @RequestMapping("/hia")
    public String home(@RequestParam String name) {
        System.out.println("hia "+name+",i am from port:" +port);
        return "hia "+name+",i am from port:" +port;
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/callhome")
    public String callHome(){
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://192.168.1.104:8763/hi", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace service-hi ");

        return "i'm service-hi";

    }
}
