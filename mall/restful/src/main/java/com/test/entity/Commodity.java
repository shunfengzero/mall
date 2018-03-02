package com.test.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Commodity implements Serializable{
    private String sku;
    private String name;
    private  float price;
    private int cateid;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }
}
