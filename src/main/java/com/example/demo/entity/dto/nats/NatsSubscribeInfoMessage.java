package com.example.demo.entity.dto.nats;

import lombok.Data;

@Data
public class NatsSubscribeInfoMessage {

    private String tag;

    private Integer value;

    private Integer quality;

    private Long timestamp;
}
