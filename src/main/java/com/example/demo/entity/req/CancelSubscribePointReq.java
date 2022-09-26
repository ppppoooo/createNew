package com.example.demo.entity.req;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * 取消节点订阅入参
 */
@Data
public class CancelSubscribePointReq {

    /**
     * 节点列表
     */
    @NotNull(message = "节点列表不能为空")
    private Set<String> pointSet;

}

