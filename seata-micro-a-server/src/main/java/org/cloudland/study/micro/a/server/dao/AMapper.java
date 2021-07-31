package org.cloudland.study.micro.a.server.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lei
 * @date 2021/7/31 13:38
 */
@Mapper
public interface AMapper {

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    Integer add(AEntity entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    Integer update(AEntity entity);

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    Integer delete(AEntity entity);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    List<AEntity> find(String id);


}
