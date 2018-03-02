package com.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface ImgDao {

    public void saveImg(Map<String, Object> data);
}
