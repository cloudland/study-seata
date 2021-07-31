package org.cloudland.study.micro.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微服务(A)启动类
 *
 * @author lei
 * @date 2021/6/25 10:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroAServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroAServerApplication.class, args);
    }

}
