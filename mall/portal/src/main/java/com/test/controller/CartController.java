package com.test.controller;

import com.test.entity.Commodity;
import com.test.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    private CartService cs;
    //restful风格的路径,
    @RequestMapping("add/{sku}")
    public String addCart(@PathVariable  String sku, @CookieValue(value = "cart",required = false)String cart, HttpServletResponse res, Model model){
         cs.addCart(sku,cart,res,model);

        return "cart";
    }

    //    更新数量
    @RequestMapping("update/{sku}/{num}")
    @ResponseBody
    public String update(@PathVariable String sku,@PathVariable int num,@CookieValue(value = "cart",required = false)String cart, HttpServletResponse res){
        String s=""+cs.update(sku,num,cart,res);
        System.out.println(s);
        return s;
    }
    //    查看购物车
    @RequestMapping("lookcart")
    public String lookCart(@CookieValue(value = "cart",required = false)String cart,Model model){
        cs.lookCart(cart,model);
        return "cart";
    }

}
