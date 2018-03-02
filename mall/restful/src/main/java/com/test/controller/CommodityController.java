package com.test.controller;

import com.test.entity.Commodity;
import com.test.service.CommodityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {
    @Resource
    private CommodityService cs;
    @RequestMapping("findCommodityBySku/{sku}")
    public Commodity findCommodityBySku(@PathVariable String sku){
         return  cs.findCommodityBySku(sku);
    }

    @RequestMapping("zhekou/{total}")
    public String zhekou(@PathVariable float total) {
        Map<String, Object> data = new HashMap<>();
        data.put("x", total);
        cs.zhekou(data);
        return ""+data.get("y");
    }

}
