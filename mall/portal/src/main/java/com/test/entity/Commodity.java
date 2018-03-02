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
    private int num;//购物车中该商品的数量

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

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
