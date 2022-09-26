package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.req.CancelSubscribeDeviceReq;
import com.example.demo.entity.req.CancelSubscribePointReq;
import com.example.demo.entity.req.SubscribeDeviceReq;
import com.example.demo.entity.req.SubscribePointReq;

import java.util.Set;

public interface TopologyService {

    void subscribePoints(SubscribePointReq req);

    void cancelSubscribePoints(CancelSubscribePointReq req);

    void subscribeDevices(SubscribeDeviceReq req);

    void cancelSubscribeDevices(CancelSubscribeDeviceReq req);

    Set<String> getPoints();

    Set<String> getDevices();

    JSONArray get();

}
