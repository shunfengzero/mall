package com.test.controller;

import com.test.entity.User;
import com.test.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @RequestMapping("assignUserRoles")
    public String  assignUserRoles(int id, String rid) {

        /*System.out.println(user.getId());
        System.out.println(rid);*/

        String[] ids = rid.split(",");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            list.add(Integer.parseInt(ids[i]));
//           userRoleService.assignUserRoles(user.getId(),Integer.parseInt(ids[i]));
            System.out.println("--" + ids[i] +"---");

        }
        userRoleService.assignUserRoles(id,list);

        return "1";
    }

}
