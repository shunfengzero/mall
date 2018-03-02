package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.entity.Category;
import com.test.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@RestController
public class CategoryController {
    @Resource
    private CategoryService cs;
    @RequestMapping("findAllCategoryForPortal")
    public String findAllCategoryForPortal(){
        List<Category> data=cs.findAllCategoryForPortal();
        String s = JSON.toJSONString(data);
        String json="category.getDataService({\"data\":"+s+"})";
        return json;
    }
}
