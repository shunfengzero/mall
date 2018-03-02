package com.test.service;


import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

@Configuration
public class WSConfig {

    @Resource
    private FirstService fs;

    @Resource
    private Bus bus; //消息总线

    @Bean
    public Endpoint first() {
        EndpointImpl x = new EndpointImpl(bus,fs);
        x.publish("/first");
        return x;
    }
}
