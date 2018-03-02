package com.test.service;

import com.test.dao.ImgDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ImgService {
    @Resource
    private ImgDao md;


    public void saveImg(Map<String, Object> data) {
        md.saveImg(data);
    }
}
