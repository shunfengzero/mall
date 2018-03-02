package com.test.controller;

import com.test.entity.Category;

import com.test.service.CategoryService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("findAllCategory")
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }


    @RequestMapping("saveCategory")
   public String saveCategory(Category category) {
       Integer pid = category.getParentId();

       if (pid  == -1) {

           categoryService.saveCategory(category);
       } else {
           int parentId = category.getParentId();
           categoryService.updateCategory(category);
       }
       return "1";
   }

   @RequestMapping("deleteCategory")
    public String deleteCategory(@RequestBody ArrayList<Integer> data) {

        categoryService.deleteCategory(data);

        return "1";
   }

}
