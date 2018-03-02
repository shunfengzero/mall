package com.test.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    //md5加密
    public static String encrypt(String src) {
        StringBuilder sd = null;
        try {
            //创建消息摘要实例对象
            MessageDigest  md5 = MessageDigest.getInstance("MD5");
            //摘要
            byte[] a = md5.digest(src.getBytes());
             sd = new StringBuilder();
            for (int i = 0; i < a.length ; i++) {
                int x = (int)a[i]&0xff;
                //加盐
                x = x + 1;
                if (x < 16) {
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }

            System.out.println(sd.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sd.toString();
    }

    public static void main(String[] args ) {
        encrypt("abc");
    }

}
