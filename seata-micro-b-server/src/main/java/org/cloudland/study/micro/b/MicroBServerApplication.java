package org.cloudland.study.micro.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微服务(B)启动类
 *
 * @author lei
 * @date 2021/6/25 10:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroBServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroBServerApplication.class, args);
    }

}
