package org.cloudland.study.seata.server.control.vo;

import lombok.Data;

/**
 * @author lei
 * @date 2021/7/31 15:46
 */
@Data
public class SeataTransactionEditVo {

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
