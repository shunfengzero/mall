package com.test.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ESController {

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    //创建索引
    @RequestMapping("createIndex")
    public String createIndex() {
        RestTemplate template = restTemplateBuilder.build();
        template.put("http://localhost:9200/sf",null);
        return "success";
    }
}
