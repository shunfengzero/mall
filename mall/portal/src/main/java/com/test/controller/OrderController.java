package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.test.config.AlipayConfig;
import com.test.entity.Commodity;
import com.test.entity.Order;
import com.test.entity.Pay;
import com.test.service.CartService;
import com.test.service.OrderService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService os;

    @Resource
    private CartService cs;
    @RequestMapping("toOrder")
    public String toOrder(@CookieValue(value = "cart",required = false)String cart, Model model) {
            cs.lookCart(cart,model);
            return "order";

    }

    //创建订单并支付
    @RequestMapping("saveOrder")
    @ResponseBody
    public String saveOrder(@CookieValue(value="cart",required = false) String ck) {
        //1.创建订单
        //设计表结构
        //订单编号
        String uuid = UUID.randomUUID().toString();
        long time = System.currentTimeMillis();
        String orderNo = uuid + time;
        Map<String, Commodity> cart = cs.getCart(ck);
        float total = cs.total(cart);
        Order od = new Order();
        od.setOrderno(orderNo);
        od.setTotal(total);

        os.sendOrderMessage(JSON.toJSONString(od));

        //2.支付
        Pay p = new Pay();
        p.setOut_trade_no(orderNo);
        p.setTotal_amount(1);
        p.setSubject("aa");
        p.setBody("");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String json = JSON.toJSONString(p);
        alipayRequest.setBizContent(json);
        try {
            return     alipayClient.pageExecute(alipayRequest).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";

    }

}






























