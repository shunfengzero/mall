package com.test.service;

import com.test.dao.UserRoleDao;
import com.test.entity.Role;
import com.test.entity.User;
import com.test.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;



  /* public void assignUserRoles1(Integer uid,Integer rid) {

        User user = new User();
        Role role = new Role();
        UserRole userRole = new UserRole();
        user.setId(uid);
       // role.setRid(rid);
        userRole.setUser(user);
       // userRole.setRole(role);


        List<Integer> list = userRoleDao.findAllUserRole(userRole);
       Map<String,Integer> map2 = new HashMap<>();
       Boolean flag = true;
        if (list.size() == 0) {
            flag = false;
        } else {
            for (Integer r:list) {

                if (r != rid) {

                    flag = false;


                } else {
                    System.out.println("不能添加相同名字的权限");
                    flag = true;
                    break;
                }
        }
       }


      if (flag) {
          System.out.println("不能添加相同名字的权限");
      } else {
          map2.put("uid",uid);
          map2.put("rid",rid);
          userRoleDao.assignUserRoles(map2);
      }

    }*/

  @Transactional
    public void assignUserRoles(Integer uid,List<Integer> rids) {



            userRoleDao.deleteURId(uid);
            Map<String,Object> map = new HashMap<>();
            map.put("uid",uid);
            map.put("rids",rids);
            userRoleDao.assignUserRoles(map);

       // List<Integer> list = userRoleDao.findAllUserRole(userRole);

    }
}
