package org.cloudland.study.seata.server.control;

import org.cloudland.study.seata.server.control.vo.SeataTransactionEditVo;
import org.cloudland.study.seata.server.service.SeataMyBatisService;
import org.cloudland.study.seata.server.service.dto.SeataTransactionDo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Seata 分布式事务学习测试
 *
 * @author lei
 * @date 2021/7/31 15:43
 */
@RestController
@RequestMapping("/seata/mybatis")
public class SeataMyBatisEditControl extends AbstractParentControl {

    /**
     * Seata 基于 MyBatis 分布式事务
     */
    @Resource(name = "Web.Study.SeataMyBatisService")
    private SeataMyBatisService service;

    /**
     * 分布式事务测试
     *
     * @param request  请求
     * @param response 响应
     * @param editVo   数据对象
     * @return 处理结果
     */
    @PostMapping(value = "/distribute")
    public JsonResult<String> create(HttpServletRequest request, HttpServletResponse response, @RequestBody SeataTransactionEditVo editVo) {
        getLogger().info("[主服务][分布式事务]新增数据");

        service.doTransaction(new SeataTransactionDo(editVo.getId(), editVo.getTitle(), editVo.getContent(), editVo.getAuthor(), editVo.getPublisher()));
        return doSuccess(null);
    }

}
