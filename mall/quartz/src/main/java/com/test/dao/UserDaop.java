package com.test.dao;

import com.test.entity.User1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "rr")
@Mapper
public interface UserDaop {

    public List<User1> findAllUsers();
}
