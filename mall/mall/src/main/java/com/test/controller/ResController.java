package com.test.controller;

import com.test.entity.Res;
import com.test.entity.Res2;
import com.test.entity.User;
import com.test.service.ResService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResController {

    @Resource
    private ResService resService;

    @RequestMapping("findAllRes")
    public List<Res> findAllRes(HttpSession session){

        User user = (User)session.getAttribute("user");

        return resService.findAllRes(user);
    }
    @RequestMapping("findAllResForRole")
    public List<Res> findAllResForRole() {

        return resService.findAllResForRole();
    };

    @RequestMapping("findRes")
    public Map<String,Object> findRes() {

        Map<String,Object> map = new HashMap<>();
        List<Object> res = resService.findRes();
        map.put("rows",res);

        return map;
    }

    @RequestMapping("saveRess")
    public String saveRess(Res res) {

        //Integer id = res.getId();
        String pid = res.getParentId();

        if (pid.equals("-1")) {

            resService.saveRess(res);
        } else {

            resService.updateRess(res);
        }
      return "1";
    }

    @RequestMapping("deleteRess")
    public String deleteRess(@RequestBody ArrayList<Integer> data) {

        resService.deleteRess(data);

        return "1";
    }

    //通过角色id查找角色所拥有的权限
    @RequestMapping("findRoleResByRoleId")
    public List<Res> findRoleResByRoleId(int rid) {


        return resService.findRoleResByRoleId(rid);
    }
}
