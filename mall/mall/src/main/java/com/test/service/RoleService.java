package com.test.service;

import com.test.dao.RoleDao;
import com.test.entity.Role;
import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<Role> findAllRole() {

      return  roleDao.findAllRole();
    }

    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
    public void updateRole(Role role){
        roleDao.updateRole(role);
    }
    public void deleteRole(ArrayList<Integer> list) {
        roleDao.deleteRole(list);
    }

    public List<Role> findAllRoleByUid(User user){
        return roleDao.findAllRoleByUid(user);
    }

    @Transactional
    public void fenpei(Map<String, Object> data) {
        roleDao.deleteOld(data.get("rid"));
        roleDao.fenpei(data);
    }
}
