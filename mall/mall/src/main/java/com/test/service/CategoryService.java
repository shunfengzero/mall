package com.test.service;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryDao categoryDao;

  //  @Cacheable(value = "findAllCategory")
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    public void saveCategory(Category category) {
        Integer id = category.getId();
        if (id == -1) {
            category.setParentId(0);
        } else {
            category.setParentId(id);
        }

        categoryDao.saveCategory(category);
    }

    public void updateCategory(Category category) {



        categoryDao.updateCategory(category);

    }
    public void deleteCategory(ArrayList<Integer> data) {

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer rid : data) {

            Category category = categoryDao.findCategoryByPId(rid);

            if (category == null || category.equals("")) {
                list.add(rid);
            }

        }

        categoryDao.deleteCategory(list);
    }


}
