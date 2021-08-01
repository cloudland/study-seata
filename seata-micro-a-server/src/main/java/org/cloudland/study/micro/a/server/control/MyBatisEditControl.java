package org.cloudland.study.micro.a.server.control;

import io.seata.spring.annotation.GlobalTransactional;
import org.cloudland.study.micro.a.server.control.vo.TransactionTestEditVo;
import org.cloudland.study.micro.a.server.service.MyBatisService;
import org.cloudland.study.micro.a.server.service.dto.TransactionTestDo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyBatis事物测试控制器
 *
 * @author lei
 * @date 2021/6/24 18:29
 */
@RestController
@RequestMapping("/study/mybatis")
public class MyBatisEditControl extends AbstractParentControl {

    /**
     * MyBatis事物测试服务
     */
    @Resource(name = "Web.Study.MyBatisService")
    private MyBatisService service;

    /**
     * 新增数据
     *
     * @param request  请求
     * @param response 响应
     * @param editVo   数据对象
     * @return 处理结果
     */
    @PostMapping(value = "/data")
    public JsonResult<String> create(HttpServletRequest request, HttpServletResponse response, @RequestBody TransactionTestEditVo editVo) {
        getLogger().info("[微服务(A)][新增]新增数据");

        return doSuccess(service.create(new TransactionTestDo(editVo.getId(), editVo.getTitle(), editVo.getContent())));
    }

    /**
     * 更新数据
     *
     * @param request  请求
     * @param response 响应
     * @param editVo   数据对象
     * @return 处理结果
     */
    @PutMapping(value = "/data")
    public JsonResult<String> update(HttpServletRequest request, HttpServletResponse response, @RequestBody TransactionTestEditVo editVo) {
        getLogger().info("[微服务(A)][更新]新增数据");

        return doSuccess(service.update(new TransactionTestDo(editVo.getId(), editVo.getTitle(), editVo.getContent())));
    }

    /**
     * 删除数据
     *
     * @param request  请求
     * @param response 响应
     * @param id       数据标识
     * @return 处理结果
     */
    @DeleteMapping(value = "{id}")
    public JsonResult<Void> remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        getLogger().info("[微服务(A)][删除]新增数据");

        service.remove(id);
        return doSuccess(null);
    }

    /**
     * 查询数据
     *
     * @param request  请求
     * @param response 响应
     * @param id       数据标识
     * @return 处理结果
     */
    @GetMapping(value = "{id}")
    public JsonResult<Void> find(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        getLogger().info("[微服务(A)][查询]新增数据");

        service.find(id);
        return doSuccess(null);
    }

    /**
     * 两表事务
     *
     * @param request
     * @param response
     * @param editVo
     * @return
     */
    @PostMapping(value = "/transaction")
    public JsonResult<Void> doTransaction(HttpServletRequest request, HttpServletResponse response, @RequestBody TransactionTestEditVo editVo) {
        getLogger().info("[微服务(A)][事务]新增数据");

        service.doTransaction(new TransactionTestDo(editVo.getId(), editVo.getTitle(), editVo.getContent()));
        return doSuccess(null);
    }

}
