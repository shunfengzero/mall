package com.test.controller;

import com.test.service.UserService;
import com.test.util.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.entity.User;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("findAllUser")
    //public List<Map<String,Object>> findAllUser() {
        public Map<String, Object> findAllUser(int page, int rows) {
        int start = (page - 1) * rows;
        Map<String, Integer> data = new HashMap<>();
        data.put("start",start);
        data.put("size", rows);
        return userService.findAllUser(data);
    }
    @RequestMapping("getCount")
    public int getCount() {
        return userService.getCount();
    }

    @RequestMapping("saveUser")
    public String saveUser(User user) {

       int id = user.getId();
       if (id != 0) {
           //修改
           userService.updateUser(user);

       } else {
            String x = SecurityUtil.encrypt(user.getPwd());
            user.setPwd(x);
           //保存
           userService.saveUser(user);
       }
        return "1";
    }

    @RequestMapping("delUser")
    //public String delUser(String ids) {
        public String delUser(@RequestBody ArrayList<Integer> data) {

                userService.delUser(data);

        //System.out.println(user.getId());
      /*  System.out.println(ids);
        String[] nids = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nids.length; i++) {
            System.out.println(nids[i]);

            list.add(Integer.parseInt(nids[i]));
        }

        userService.delUser(list);*/

       /* try {

            userService.delUser(user);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }*/
        return "1";
    }

    //登录
    @RequestMapping("login")
    public String login(User user, HttpSession session) {

        String x = SecurityUtil.encrypt(user.getPwd());
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),x);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            user.setPwd(x);
            User u2 = userService.login(user);
            session.setAttribute("user",u2);
            return "1";
        } catch (AuthenticationException e) {
            return "0";




        }

    }

    @RequestMapping("logout")
    public String lougout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "退出";
    }
}
