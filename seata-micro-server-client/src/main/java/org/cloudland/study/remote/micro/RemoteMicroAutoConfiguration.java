package org.cloudland.study.remote.micro;

import com.netflix.hystrix.HystrixCommand;
import feign.Feign;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 登录中心封装调用第三方客户端自动配置
 *
 * @author lei
 * @date 2021/7/2 16:40
 */
@Configuration(proxyBeanMethods = false)
@EnableFeignClients
public class RemoteMicroAutoConfiguration {

    /**
     * 配置 Feign 日志
     *
     * @return 日志配置
     */
    @Bean
    @ConditionalOnMissingBean
    public Logger.Level configurationFeignLogger() {
        return Logger.Level.FULL;
    }

    /**
     * 配置 Feign Fallback 开启
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass({HystrixCommand.class, HystrixFeign.class})
    protected static class HystrixFeignConfiguration {

        @Bean
        @Scope("prototype")
        @ConditionalOnMissingBean
        public Feign.Builder feignHystrixBuilder() {
            return HystrixFeign.builder();
        }

    }

}
