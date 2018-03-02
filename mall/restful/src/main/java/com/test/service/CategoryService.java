package com.test.service;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao cd;
    @Cacheable(value = "findAllCategoryForPortal")
    public List<Category> findAllCategoryForPortal() {
        List<Category> a=cd.findAllCategoryForPortal();
        List<Category> b=new ArrayList<>();
        List<Category> c=new ArrayList<>();
        b.addAll(a);
        //组装父子关系
        for(Category p :a){
            System.out.println("递归");

            if(p.getParentId()==0){
                c.add(p);
            }
            for(Category s:b){
                if(s.getParentId()==p.getId()){
                    String sid=""+s.getId();
                    if(sid.startsWith("3")){
                       p.getChildren().add("a.html|"+s.getName());
                    }else{
                    //添加到父节点
                  p.getChildren().add(s);}
                }
            }
        }

        return c;
    }
}
