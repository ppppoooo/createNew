package com.example.demo.entity.req;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.NotNull;
/**
 * 节点订阅入参
 */
@Data
public class SubscribePointReq {

    /**
     * 节点列表
     */
    @NotNull(message = "节点列表不能为空")
    private Set<String> pointSet;

}
