package org.cloudland.study.seata.server.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.cloudland.study.remote.micro.Result;
import org.cloudland.study.seata.server.service.dto.SeataTransactionDo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Seata 基于 MyBatis 分布式事务
 *
 * @author lei
 * @date 2021/7/31 15:53
 */
@Service("Web.Study.SeataMyBatisService")
public class SeataMyBatisService extends AbstractParentService {

    /**
     * 微服务(A)调用服务
     */
    @Resource
    private org.cloudland.study.remote.micro.a.MyBatisFeignClient aClient;

    /**
     * 微服务(B)调用服务
     */
    @Resource
    private org.cloudland.study.remote.micro.b.MyBatisFeignClient bClient;

    /**
     * 两个微服务
     *
     * @param seataDo
     */
    @GlobalLock
    @GlobalTransactional(rollbackFor = {Exception.class, RuntimeException.class}, timeoutMills = 300000)
    public void doTransaction(SeataTransactionDo seataDo) {
        getLogger().info("开始全局事务，XID = " + RootContext.getXID());

        // 调用微服务(A)
        org.cloudland.study.remote.micro.a.to.TransactionTestTo a = new org.cloudland.study.remote.micro.a.to.TransactionTestTo(seataDo.getId(), seataDo.getTitle(), seataDo.getContent());
        Result<Void> aResult = aClient.doTransaction(a);
        getLogger().info("微服务(A): {}", aResult.getCode());

        // 调用微服务(B)
        org.cloudland.study.remote.micro.b.to.TransactionTestTo b = new org.cloudland.study.remote.micro.b.to.TransactionTestTo(seataDo.getId(), seataDo.getTitle(), seataDo.getContent());
        Result<Void> bResult = bClient.doTransaction(b);
        getLogger().info("微服务(B): {}", bResult.getCode());

    }

}
