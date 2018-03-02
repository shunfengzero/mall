package com.test.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private JmsTemplate jmsTemplate;

    //发消息
    public void sendOrderMessage(String json) {
        jmsTemplate.convertAndSend("first",json);
    }
}
