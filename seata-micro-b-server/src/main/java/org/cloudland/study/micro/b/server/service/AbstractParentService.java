package org.cloudland.study.micro.b.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务层公共基础服务类
 *
 * @author lei
 * @date 2021/6/24 16:32
 */
public class AbstractParentService {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取日志对象
     *
     * @return 日志对象
     */
    protected Logger getLogger() {
        return LOGGER;
    }

}
