package com.example.demo.task;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.CommonConstant;
import com.example.demo.entity.dto.nats.NatsSubscribeInfoMessage;
import com.example.demo.mq.nats.NatsProduce;
import com.example.demo.service.TopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Set;

@Configuration
@EnableScheduling
public class TopologyTask {

    @Autowired
    private TopologyService topologyService;

    @Autowired
    private NatsProduce natsProduce;

    //    @Scheduled(fixedRate=500)
    private void configureTasks() {
        Set<String> points = topologyService.getPoints();
        Set<String> devices = topologyService.getDevices();
        // todo 查库
        for (String device : devices) {
            System.out.println(device);
        }

        for (String point : points) {
            NatsSubscribeInfoMessage natsSubscribeInfo = new NatsSubscribeInfoMessage();
            natsProduce.publish(CommonConstant.NATS_SUBSCRIBE_SUBJECT_ + point, JSONObject.toJSONString(natsSubscribeInfo));
            System.out.println(point);
        }

        //todo 发mq

    }
}