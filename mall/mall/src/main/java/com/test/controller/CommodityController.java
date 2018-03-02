package com.test.controller;

import com.test.entity.Commodity;
import com.test.service.CommodityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

    @Resource
    private CommodityService cs;

    @RequestMapping("findAllComms")
    public List<Commodity> findAllComms() {
        return cs.findAllComms();
    }

    @RequestMapping("addCommodity")
    public String addCommodity(@RequestParam("f1") MultipartFile file, @RequestParam Map<String,String> data) {
        
        cs.addCommodity(file,data);
        return null;
    }


    @RequestMapping("shangjia")
    public String shangjia(String sku) {
        cs.shangjia(sku);

        return "1";
    }

}
