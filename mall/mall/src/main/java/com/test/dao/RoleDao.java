package com.test.dao;

import com.test.entity.Role;
import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RoleDao {

    public List<Role> findAllRole();
    public void saveRole(Role role);
    public void updateRole(Role role);

    public void deleteRole(ArrayList<Integer> data);
    public List<Role> findAllRoleByUid(User user);
    public void deleteOld(Object rid);
    public  void fenpei(Map<String, Object> data);
}
