package com.test.dao;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    public List<Map<String,Object>> findAllUser(Map<String, Integer> map);
    public List<User> findAllUser2(Map<String, Integer> map);
    public List<User> findAllUser3(Map<String, Integer> map);
    public int getCount();
    public void saveUser(User user);
   // public void delUser(List<Integer> id);
    public void delUser(ArrayList<Integer> data);
    public void updateUser(User user);

    public User login(User user);
}
