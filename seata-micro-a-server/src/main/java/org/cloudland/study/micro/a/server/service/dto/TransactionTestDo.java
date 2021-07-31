package org.cloudland.study.micro.a.server.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lei
 * @date 2021/7/31 13:02
 */
@Getter
@AllArgsConstructor
public class TransactionTestDo {

    /**
     * 标识符
     */
    private String id;

    /**
     * 姓名
     */
    private String title;

    /**
     * 年龄
     */
    private String content;

}
