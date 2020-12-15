package cn.coget.test.eureka.client.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/system/getAppName")
    public String getAppName() {
        return appName;
    }

    @GetMapping("/system/getInstanceInfo")
    public String getInstanceInfo() {
        return JSON.toJSONString(eurekaClient.getApplications());
    }
}
