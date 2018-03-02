package com.test.service;

import com.test.dao.CommodityDao;
import com.test.entity.Commodity;
import com.test.util.ThreadUtil;
import com.test.util.UUIDUtil;
import freemarker.template.Template;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityService {

    @Resource
    private CommodityDao cd;
    @Resource
    private ImgService ms;
    @Resource
    private FreeMarkerConfig freeMarkerConfig;
    public List<Commodity> findAllComms() {
        return cd.findAllComms();
    }

    public void addCommodity (MultipartFile file, Map<String,String> data) {

        System.out.println("start" + System.currentTimeMillis());
        String owner = UUIDUtil.createID();
        //使用线程池开启子线程来保存文件
        ThreadUtil.pool.execute(new Runnable() {
            @Override
            public void run() {
                File f = new File("F:/commoimage/" + file.getOriginalFilename());
                Map<String, Object> p = new HashMap<String, Object>();
                p.put("path", f.getAbsolutePath());
                p.put("owner", owner);

                try {
                    file.transferTo(f);
                    ms.saveImg(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        data.put("sku",owner);
        cd.addCommodity(data);
        System.out.println("end" + System.currentTimeMillis());
    }


    public void shangjia(String sku) {
        Commodity cmd = cd.shangjia(sku);


        try {
            Map<String, Object> data = new HashMap<>();
            data.put("cmd",cmd);
            FileWriter out = new FileWriter("F:/commoimage/" + sku + ".html");
            Template template = freeMarkerConfig.getConfiguration().getTemplate("item.ftl");
            //创建静态页面
            template.process(data,out);
            template.dump(out);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
