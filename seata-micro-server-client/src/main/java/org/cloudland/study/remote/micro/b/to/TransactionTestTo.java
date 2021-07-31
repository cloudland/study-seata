package org.cloudland.study.remote.micro.b.to;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lei
 * @date 2021/7/31 15:25
 */
@Getter
@AllArgsConstructor
public class TransactionTestTo {

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
