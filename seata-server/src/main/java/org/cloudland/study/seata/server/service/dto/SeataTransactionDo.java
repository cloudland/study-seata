package org.cloudland.study.seata.server.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 *
 * @author lei
 * @date 2021/7/31 16:02
 */
@Getter
@AllArgsConstructor
public class SeataTransactionDo {

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

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

}
