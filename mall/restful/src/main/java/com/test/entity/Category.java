package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/24.
 */
public class Category implements Serializable {
     private int id;
     @JSONField(name = "n")//指定key的名称
     private String name;
     @JSONField(name = "u")
     private String url="a.html";
     private int parentId;
     @JSONField(name = "i")
     private Set<Object> children=new LinkedHashSet<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Object> getChildren() {
        return children;
    }

    public void setChildren(Set<Object> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
