package cn.coget.test.eureka.client2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-client1")
public interface Client1Client {

    @GetMapping("/system/getInstanceInfo")
    String getInstanceInfo();
}
