package com.example.demo.entity.dto.nats;

import lombok.Data;


@Data
public class NatsErrorEndMessage {

    /**
     * uuid
     */
    private String id;

    /**
     * 节点
     */
    private String tag;

    /**
     * 恢复值
     */
    private Integer value;

    /**
     * 恢复时间（时间戳）
     */
    private Long recoverTime;
}
