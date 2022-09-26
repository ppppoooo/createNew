package com.example.demo.entity.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;
/**
 * 取消设备订阅入参
 */
@Data
public class CancelSubscribeDeviceReq {

    /**
     * 设备列表
     */
    @NotNull(message = "设备列表不能为空")
    private Set<String> deviceSet;
}