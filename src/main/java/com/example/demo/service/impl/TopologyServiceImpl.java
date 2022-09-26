package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.constant.RedisConstant;
import com.example.demo.entity.req.CancelSubscribeDeviceReq;
import com.example.demo.entity.req.CancelSubscribePointReq;
import com.example.demo.entity.req.SubscribeDeviceReq;
import com.example.demo.entity.req.SubscribePointReq;
import com.example.demo.service.TopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TopologyServiceImpl implements TopologyService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void subscribePoints(SubscribePointReq req) {
        String[] node = new String[req.getPointSet().size()];
        req.getPointSet().toArray(node);
        redisTemplate.opsForSet().add(RedisConstant.TOPOLOGY_SUBSCRIBE_POINT_SET, node);
    }

    /**
     * 取消订阅节点
     *
     * @param req
     * @return
     */
    @Override
    public void cancelSubscribePoints(CancelSubscribePointReq req) {
        String[] node = new String[req.getPointSet().size()];
        req.getPointSet().toArray(node);
        redisTemplate.opsForSet().remove(RedisConstant.TOPOLOGY_SUBSCRIBE_POINT_SET, node);
    }

    /**
     * 订阅设备
     *
     * @param req
     * @return
     */
    @Override
    public void subscribeDevices(SubscribeDeviceReq req) {
        String[] node = new String[req.getDeviceSet().size()];
        req.getDeviceSet().toArray(node);
        redisTemplate.opsForSet().add(RedisConstant.TOPOLOGY_SUBSCRIBE_DEVICE_SET, node);
    }

    /**
     * 取消订阅设备
     *
     * @param req
     * @return
     */
    @Override
    public void cancelSubscribeDevices(CancelSubscribeDeviceReq req) {
        String[] node = new String[req.getDeviceSet().size()];
        req.getDeviceSet().toArray(node);
        redisTemplate.opsForSet().remove(RedisConstant.TOPOLOGY_SUBSCRIBE_DEVICE_SET, node);
    }

    /**
     * 获取所有节点
     * @return
     */
    public Set<String> getPoints(){
        return redisTemplate.opsForSet().members(RedisConstant.TOPOLOGY_SUBSCRIBE_POINT_SET);
    }

    /**
     * 获取所有设备
     * @return
     */
    public Set<String> getDevices(){
        return redisTemplate.opsForSet().members(RedisConstant.TOPOLOGY_SUBSCRIBE_DEVICE_SET);
    }

    @Override
    public JSONArray get() {
        Set<String> members1 = getPoints();
        Set<String> members2 = getDevices();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(members1);
        jsonArray.add(members2);
        return jsonArray;
    }


}
