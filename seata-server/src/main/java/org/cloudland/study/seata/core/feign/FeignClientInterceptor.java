package org.cloudland.study.seata.core.feign;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * FeignClient 请求拦截器
 * <br>
 * 针对所有 Feign 方式请求进行拦截，做一些预设处理操作
 *
 * @author zhuzhonglei@gsafety.com
 * @date 2021/7/3 16:16
 */
@Aspect
@Component
public class FeignClientInterceptor {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取日志对象
     *
     * @return
     */
    private Logger getLogger() {
        return LOGGER;
    }

    /**
     * 拦截所有使用 @FeignClient 注解类或接口的方法
     *
     * @param point 切入点
     * @return
     */
    @Around("@within(org.springframework.cloud.openfeign.FeignClient)")
    public Object doInterceptor(ProceedingJoinPoint point) {
        // 将父线程 Request 绑定给子线程，解决 Feign 的 RequestInterceptor 中获取不到当前 Request 问题
        RequestContextHolder.setRequestAttributes(RequestContextHolder.getRequestAttributes(), true);

        // 直接调用目标方法
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            // 输出日志, 不做处理直接抛出
            getLogger().error("[Supervise][Feign]代理使用@FeignClient注解的类或接口, 调用其方法执行异常.", e);
            throw new RuntimeException(e);
        }

        return result;
    }

}
