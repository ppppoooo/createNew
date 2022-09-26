package com.example.demo.controller;

import com.example.demo.constant.CommonConstant;
import com.example.demo.entity.dto.CommonRespDTO;
import com.example.demo.entity.req.CancelSubscribeDeviceReq;
import com.example.demo.entity.req.CancelSubscribePointReq;
import com.example.demo.entity.req.SubscribeDeviceReq;
import com.example.demo.entity.req.SubscribePointReq;
import com.example.demo.mq.nats.NatsProduce;
import com.example.demo.service.TopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/topology")
public class TopologyController {

    @Autowired
    private TopologyService topologyService;

    /**
     * 订阅节点
     *
     * @param req
     * @return
     */
    @PostMapping("/subscribePoints")
    public CommonRespDTO subscribePoints(@RequestBody @Validated SubscribePointReq req) {
        topologyService.subscribePoints(req);
        return CommonRespDTO.success();

    }

    /**
     * 取消订阅节点
     *
     * @param req
     * @return
     */
    @PostMapping("/cancelSubscribePoints")
    public CommonRespDTO cancelSubscribePoints(@RequestBody @Validated CancelSubscribePointReq req) {
        topologyService.cancelSubscribePoints(req);
        return CommonRespDTO.success();
    }

    /**
     * 订阅设备
     *
     * @param req
     * @return
     */
    @PostMapping("/subscribeDevices")
    public CommonRespDTO subscribeDevices(@RequestBody @Validated SubscribeDeviceReq req) {
        topologyService.subscribeDevices(req);
        return CommonRespDTO.success();
    }

    /**
     * 取消订阅设备
     *
     * @param req
     * @return
     */
    @PostMapping("/cancelSubscribeDevices")
    public CommonRespDTO cancelSubscribeDevices(@RequestBody @Validated CancelSubscribeDeviceReq req) {
        topologyService.cancelSubscribeDevices(req);
        return CommonRespDTO.success();
    }

    /**
     * 查看所有
     *
     * @return
     */
    @GetMapping("get")
    public CommonRespDTO get() {
        return CommonRespDTO.success(topologyService.get());
    }

    @Autowired
    private NatsProduce natsProduce;

    @RequestMapping("/publish")
    public void publish() {
        natsProduce.publish(CommonConstant.NATS_SUBJECT_TEST, "你好");

    }

}
