package com.test.service;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //public List<Map<String,Object>> findAllUser() {
    public Map<String, Object> findAllUser(Map<String, Integer> map) {

        List<User> infos = userDao.findAllUser3(map);
        int count = userDao.getCount();

        Map<String, Object> map2 = new HashMap<>();
        map2.put("total",count);
        map2.put("rows",infos);

        return map2;
    }
    public int getCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void delUser(ArrayList<Integer> list) {
        try {

            userDao.delUser(list);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User login(User user) {
        return userDao.login(user);
    }
}
