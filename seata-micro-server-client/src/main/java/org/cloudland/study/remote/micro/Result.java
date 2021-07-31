package org.cloudland.study.remote.micro;

import java.beans.ConstructorProperties;

/**
 * 结果对象
 *
 * @author lei
 * @date 2021/7/15 9:52
 */
public class Result<L> {

    /**
     * 错误码
     */
    private String code;

    /**
     * 消息, 只有当返回码为0, 此参数才会有值
     */
    private String msg;

    /**
     * 序列化对象
     */
    private L result;

    /**
     * 构造函数
     *
     * @param code   错误编码
     * @param msg    错误信息
     * @param result 结果数据
     */
    @ConstructorProperties({"code", "msg", "result"})
    public Result(String code, String msg, L result) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 请求结果
     *
     * @return 状态编码
     */
    public Integer getSuccess() {
        return null == code || code.length() <= 0 ? 1 : 0;
    }

    /**
     * 获取响应码
     *
     * @return 错误编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取提示消息
     *
     * @return 提示消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 获取数据结果
     *
     * @return 数据结果
     */
    public L getResult() {
        return result;
    }

}
