package com.test.dao;

import com.test.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@Repository
@Mapper
public interface CommodityDao {
    public Commodity findCommodityBySku(String sku);
    public void zhekou(Map<String,Object> data);
}
