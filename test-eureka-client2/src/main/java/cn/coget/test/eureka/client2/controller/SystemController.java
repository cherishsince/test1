package cn.coget.test.eureka.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SystemController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/system/getAppName")
    public String getAppName() {
        return appName;
    }

    @GetMapping("/system/getTargetName")
    public String getTargetName() {
        return restTemplate.getForObject("http://demo-client1/system/getInstanceInfo", String.class);
    }
}
