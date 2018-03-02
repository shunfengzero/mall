package com.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {


    @RequestMapping("addCommodity")
    public String addCommodity(@RequestParam("f1") MultipartFile file, @RequestParam Map<String,String> data) {




                File f = new File("F:/commoimage/" + file.getOriginalFilename());
              //  Map<String, Object> p = new HashMap<String, Object>();
              //  p.put("path", f.getAbsolutePath());


                    try {
                        file.transferTo(f);
                    //ms.saveImg(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }




        return "1";
    }
}
