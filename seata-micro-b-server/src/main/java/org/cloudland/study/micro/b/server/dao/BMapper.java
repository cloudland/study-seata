package org.cloudland.study.micro.b.server.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lei
 * @date 2021/7/31 13:38
 */
@Mapper
public interface BMapper {

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    Integer add(BEntity entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    Integer update(BEntity entity);

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    Integer delete(BEntity entity);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    List<AEntity> find(String id);


}
