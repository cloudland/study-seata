package org.cloudland.study.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 登录中心主启动类
 *
 * @author lei
 * @date 2021/6/24 12:24
 */
@SpringBootApplication
public class SeataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataServerApplication.class, args);
    }

}
