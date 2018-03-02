package com.test.dao;

import com.test.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Repository
@Mapper
public interface CategoryDao {

    public List<Category> findAllCategory();

 //   @CacheEvict(value = "findAllCategory",allEntries = true)
    public void updateCategory(Category category);
  //  @CacheEvict(value = "findAllCategory",allEntries = true)
    public void saveCategory(Category category);
  //  @CacheEvict(value = "findAllCategory",allEntries = true)
    public void deleteCategory(@RequestBody ArrayList<Integer> data);
   // @CacheEvict(value = "findAllCategory",allEntries = true)
    public Category findCategoryByPId(Integer id);
}
