package com.lanniuh.order.service.impl;

import com.lanniuh.order.dao.OrderMapper;
import com.lanniuh.order.model.Order;
import com.lanniuh.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/8/31.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

}
