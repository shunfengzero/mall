package com.test.dao;

import com.test.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommodityDao {

    public List<Commodity> findAllComms();
    public void  addCommodity(Map<String,String>  data);
    public Commodity shangjia(String sku);

}
