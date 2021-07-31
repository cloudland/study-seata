package org.cloudland.study.micro.a.server.service;

import org.cloudland.study.micro.a.server.dao.AEntity;
import org.cloudland.study.micro.a.server.dao.AMapper;
import org.cloudland.study.micro.a.server.dao.BEntity;
import org.cloudland.study.micro.a.server.dao.BMapper;
import org.cloudland.study.micro.a.server.service.dto.TransactionTestDo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MyBatis事物测试服务
 *
 * @author lei
 * @date 2021/7/31 12:50
 */
@Service("Web.Study.MyBatisService")
public class MyBatisService extends AbstractParentService {

    @Resource
    private AMapper aMapper;

    @Resource
    private BMapper bMapper;

    /**
     * 新增数据
     *
     * @param editDo 新增数据
     * @return
     */
    public String create(TransactionTestDo editDo) {
        AEntity newEntity = new AEntity(editDo.getId(), editDo.getTitle(), editDo.getContent());
        aMapper.add(newEntity);

        return newEntity.getId();
    }

    /**
     * 更新数据
     *
     * @param editDo 更新数据
     * @return
     */
    public String update(TransactionTestDo editDo) {
        AEntity newEntity = new AEntity(editDo.getId(), editDo.getTitle(), editDo.getContent());
        aMapper.update(newEntity);

        return newEntity.getId();
    }

    /**
     * 删除数据
     *
     * @param id 数据标识
     */
    public void remove(String id) {
        aMapper.delete(new AEntity(id, null, null));
    }

    /**
     * 查询数据
     *
     * @param id 数据标识
     * @return
     */
    public List<TransactionTestDo> find(String id) {
        List<AEntity> entityArray = aMapper.find(id);
        return entityArray.stream().map(entity -> new TransactionTestDo(entity.getId(), entity.getTitle(), entity.getContent())).collect(Collectors.toList());
    }

    /**
     * 两表事务
     *
     * @param editDo
     */
    public void doTransaction(TransactionTestDo editDo) {
        AEntity newAEntity = new AEntity(editDo.getId(), editDo.getTitle(), editDo.getContent());
        aMapper.add(newAEntity);

        BEntity newBEntity = new BEntity(editDo.getId(), editDo.getTitle(), editDo.getContent());
        if (0 <= newBEntity.getId().indexOf("3")) {
            throw new RuntimeException("B操作前, 回滚事务");
        }
        bMapper.add(newBEntity);

        if (0 <= newBEntity.getId().indexOf("6")) {
            throw new RuntimeException("B操作后, 回滚事务");
        }

    }

}
