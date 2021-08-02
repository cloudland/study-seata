package org.cloudland.study.seata.core.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * FeignClient 全局请求拦截器
 * <br>
 * 用于对所有请求安全监管(深圳宝安dove/em)的 Feign 添加头 Authorization
 *
 * @author lei
 * @date 2021/7/16 15:39
 */
@Configuration(proxyBeanMethods = false)
public class FeignClientRequestInterceptor implements RequestInterceptor {

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

    @Override
    public void apply(RequestTemplate template) {

        // Seata 分布式事务
//        String xid = RootContext.getXID();
//        if (StringUtils.isNotBlank(xid)) {
//            getLogger().info("[Supervise][Feign]设置传递分布式事务XID：{}", xid);
//            template.header(RootContext.KEY_XID, xid);
//        }

        // 获取当前请求头
        ServletRequestAttributes webServletAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == webServletAttributes) {
            getLogger().warn("[Supervise][Feign]请求全局拦截器, 未获取到 Web Request 对象, 终止 Feign 请求头设置, 直接发起请求。");
            return;
        }

        // 获取当前请求
        HttpServletRequest request = webServletAttributes.getRequest();
        // 获取请求头中 token
        String token = request.getHeader("token");

        // 深圳宝安微服务
        template.header(HttpHeaders.AUTHORIZATION, token);
    }

}
