package com.test.dao;

import com.test.entity.Res;
import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface ResDao {

    public List<Res> findAllRes(User user);
    public List<Res> findAllResForRole();
    public List<Res> findRes();
    public Res findResById(Integer id);
    public Res findResByPId(Integer id);
    public void saveRess(Res res);
    public void updateRess(Res res);
    public void deleteRess(ArrayList<Integer> data);
    public List<Integer> findRoleResByRoleId(Integer rid);

}
