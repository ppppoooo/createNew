package com.example.demo.mq.nats;

import io.nats.client.Connection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Component
public class NatsProduce {


    @Resource(name = "natsConnection")
    private Connection natsConnection;

    public void publish(String subject, String msg) {
        natsConnection.publish(subject, msg.getBytes(StandardCharsets.UTF_8));
    }


}
