package com.test.dao;

import com.test.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Repository
@Mapper
public interface CategoryDao {

    List<Category> findAllCategoryForPortal();
}
