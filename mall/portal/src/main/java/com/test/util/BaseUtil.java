package com.test.util;

import java.util.Base64;
/**
 * Created by Administrator on 2017/11/29.
 */
public class BaseUtil
{
    //统一编码
    public static String encode(String src){
        return Base64.getEncoder().encodeToString(src.getBytes());
    }
    public static String decode(String src){
        byte[] bytes = Base64.getDecoder().decode(src);
        return  new String(bytes);
    }

    public static void main(String[] args) {
        String s = decode("6IuP5a6a5pa5MjJkZmdkZyomXiUkPw==");
        System.out.println(s);
    }
}
