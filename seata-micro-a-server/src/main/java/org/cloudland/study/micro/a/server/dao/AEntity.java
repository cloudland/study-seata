package org.cloudland.study.micro.a.server.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author lei
 * @date 2021/7/31 13:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Micro.Study.AEntity")
public class AEntity {

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
