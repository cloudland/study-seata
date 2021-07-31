package org.cloudland.study.seata.server.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 所有控制器需要集成的基础控制类
 *
 * @author lei
 * @date 2021/6/24 16:26
 */
public class AbstractParentControl {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认每页显示记录数
     */
    private Integer DEFAULT_PAGESIZE = 10;

    /**
     * 获取日志对象
     *
     * @return
     */
    protected Logger getLogger() {
        return LOGGER;
    }

    /**
     * 默认分页大小
     *
     * @return 分页大小
     */
    protected Integer getPageSize() {
        return DEFAULT_PAGESIZE;
    }

    /**
     * 针对AJax请求的处理响应封装
     *
     * @param result true-成功
     * @return 回传结果
     */
    protected <L> JsonResult<L> doSuccess(L result) {
        return new JsonResult<>(result);
    }

    /**
     * 针对AJax请求的处理响应封装
     *
     * @param code 错误码
     * @param msg  错误消息
     * @return 回传结果
     */
    protected JsonResult<String> doError(String code, String msg) {
        return new JsonResult<>(code, msg);
    }

}

