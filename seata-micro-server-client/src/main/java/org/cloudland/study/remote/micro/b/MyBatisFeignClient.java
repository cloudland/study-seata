package org.cloudland.study.remote.micro.b;

import org.cloudland.study.remote.micro.Result;
import org.cloudland.study.remote.micro.b.to.TransactionTestTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lei
 * @date 2021/7/31 15:20
 */
@FeignClient(contextId = "Remote.Micro.B.MyBatisFeignClient", value = "micro-b-server", path = "/micro-b-server/study/mybatis")
public interface MyBatisFeignClient {

    /**
     * 新增数据
     *
     * @param editTo 数据对象
     * @return 处理结果
     */
    @PostMapping(value = "/data")
    Result<String> create(@RequestBody TransactionTestTo editTo);

    /**
     * 更新数据
     *
     * @param editTo 数据对象
     * @return 处理结果
     */
    @PutMapping(value = "/data")
    Result<String> update(@RequestBody TransactionTestTo editTo);

    /**
     * 删除数据
     *
     * @param id 数据标识
     * @return 处理结果
     */
    @DeleteMapping(value = "{id}")
    Result<Void> remove(@PathVariable("id") String id);

    /**
     * 查询数据
     *
     * @param id 数据标识
     * @return 处理结果
     */
    @GetMapping(value = "{id}")
    Result<Void> find(@PathVariable("id") String id);

    /**
     * 两表事务
     *
     * @param editVo
     * @return
     */
    @PostMapping(value = "/transaction")
    Result<Void> doTransaction(@RequestBody TransactionTestTo editVo);

}
