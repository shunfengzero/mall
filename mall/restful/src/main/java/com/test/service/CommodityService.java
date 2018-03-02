package com.test.service;

import com.test.dao.CommodityDao;
import com.test.entity.Commodity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
public class CommodityService {
    @Resource
    private CommodityDao cd;
    public Commodity findCommodityBySku(String sku) {
        return cd.findCommodityBySku(sku);
    }

    public void zhekou(Map<String, Object> data) {
        cd.zhekou(data);
    }
}
