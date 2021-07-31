package org.cloudland.study.micro.b.server.control.vo;

import lombok.Data;

/**
 * 事务测试视图对象
 *
 * @author lei
 * @date 2021/6/24 18:54
 */
@Data
public class TransactionTestEditVo {

    /**
     * 标识符
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

}
