package com.example.demo.entity.dto.nats;

import lombok.Data;

@Data
public class NatsErrorCreateMessage {
    /**
     * uuid
     */
    private String id;

    /**
     * 节点
     */
    private String tag;

    /**
     * 告警节点值
     */
    private Integer value;

    /**
     * 阈值
     */
    private Integer threthold;

    /**
     * 节点描述
     */
    private String msg;

    /**
     * 发生时间（时间戳）
     */
    private Long actionTime;
}
