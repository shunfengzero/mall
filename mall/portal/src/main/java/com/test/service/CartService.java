package com.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.test.entity.Commodity;
import com.test.util.BaseUtil;
import com.test.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
public class CartService {

    public void addCart(String sku,String ck,HttpServletResponse res,Model model){
        //购物车
        Map<String,Commodity> cart=null;

        if(StringUtils.isEmpty(ck)){
            //第一次购买
            cart=new LinkedHashMap<>();
            saveCart(sku,cart);
        }else{
            //购物车已经存于cookie
            String json = BaseUtil.decode(ck);
            //取出购物车
            cart=JSON.parseObject(json,new TypeReference< Map<String,Commodity>>(){});
            if(cart.containsKey(sku)){
                Commodity commodity = cart.get(sku);
                commodity.setNum(commodity.getNum()+1);
            }else{
               saveCart(sku,cart);
            }
        }


        //送数据到页面
        model.addAttribute("cs",cart.values());
        model.addAttribute("total",total(cart));
        model.addAttribute("zhekou",zhekou(cart));
        //转化为json
        String cartJson = JSON.toJSONString(cart);
        //使用base64编码后存入cookie
        Cookie cookie=new Cookie("cart", BaseUtil.encode(cartJson));
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        //返回给浏览器
        res.addCookie(cookie);

    }
    public void saveCart(String sku,Map<String,Commodity> cart){
        String json= HttpUtil.getData("http://localhost:8081/commodity/findCommodityBySku/"+sku);
        Commodity commodity = JSON.parseObject(json, Commodity.class);
        commodity.setNum(1);
        //存入购物车
        cart.put(sku,commodity);
    }

    //    计算总价款
    public float total(Map<String,Commodity> cart){
        float t=0;
        Collection<Commodity> cs = cart.values();
        for(Commodity c:cs){
            t=t+c.getPrice()*c.getNum();
        }
        return  t;
    }

    //更新数量
    public float update(String sku, int num,String ck,HttpServletResponse res) {
        //购物车已经存于cookie
        String json = BaseUtil.decode(ck);
        //取出购物车
        Map<String,Commodity> cart=JSON.parseObject(json,new TypeReference< Map<String,Commodity>>(){});
        Commodity commodity = cart.get(sku);
        commodity.setNum(num);
        //转化为json
        String cartJson = JSON.toJSONString(cart);
        //使用base64编码后存入cookie
        Cookie cookie=new Cookie("cart", BaseUtil.encode(cartJson));
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        //返回给浏览器
        res.addCookie(cookie);
        return total(cart);


    }

    //获取购物车
    public Map<String,Commodity> getCart(String ck) {
        String json = BaseUtil.decode(ck);
        //取出购物车
        Map<String,Commodity> cart=JSON.parseObject(json,new TypeReference< Map<String,Commodity>>(){});

        return cart;
    }

    public void lookCart(String ck, Model model) {

        //取出购物车
        Map<String,Commodity> cart= getCart(ck);
        //送数据到页面
        model.addAttribute("cs",cart.values());
        model.addAttribute("total",total(cart));

    }

    public float zhekou(Map<String,Commodity> cart) {

        String json= HttpUtil.getData("http://localhost:8081/commodity/zhekou/"+total(cart));
         return Float.parseFloat(json);
    }

}
