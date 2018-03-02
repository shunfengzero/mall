package com.test.controller;

import com.test.entity.Role;
import com.test.entity.User;
import com.test.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("findAllRole")
    public List<Role> findAllRole() {

       return roleService.findAllRole();

    }

    @RequestMapping("findAllRoleByUid")
    public List<Role> findAllRoleByUid(User user) {

        return roleService.findAllRoleByUid(user);

    }

    @RequestMapping("saveRole")
    public String saveRole(Role role) {
        int rid = role.getRid();
        if (rid != 0) {
                roleService.updateRole(role);
        } else {
                roleService.saveRole(role);
        }
        return "1";
    }

    @RequestMapping("deleteRole")
    public String deleteRole(@RequestBody ArrayList<Integer> data) {

        roleService.deleteRole(data);

        return "1";
    }

    //分配权限
    @RequestMapping("fenpei")
    public String fenpei(@RequestBody ArrayList<Integer> args) {

        Map<String, Object> data = new HashMap<>();
        data.put("rid",args.get(0));
        args.remove(0);
        data.put("ps",args);
        roleService.fenpei(data);
        return "1";

    }




}
