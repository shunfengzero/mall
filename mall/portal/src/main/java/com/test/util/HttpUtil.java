package com.test.util;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/11/29.
 */
public class HttpUtil {
    public static String getData(String url){
        try {
            URL u=new URL(url);
            //打开连接
            URLConnection con = u.openConnection();
            //获取输入流
            InputStream in = con.getInputStream();
            byte bs[]=new byte[1024];
            int count=0;
            StringBuilder sd=new StringBuilder();
            while((count = in.read(bs)) != -1){
             sd.append(new String(bs,0,count));
            }
            in.close();
            return sd.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String x = getData("https://book.douban.com/subject_search?search_text=%E4%BA%92%E8%81%94%E7%BD%91+%E7%BC%96%E7%A8%8B+%E7%AE%97%E6%B3%95");
        System.out.println(x);
    }
}
