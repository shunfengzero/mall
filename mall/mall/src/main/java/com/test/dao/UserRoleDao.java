package com.test.dao;

import com.test.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserRoleDao {

  // public void assignUserRoles(Map<String,Integer> map);
   public void assignUserRoles(Map<String,Object> map);
   public List<Integer>   findAllUserRole(UserRole userRole);
   public void  deleteURId(Integer uid);
}
