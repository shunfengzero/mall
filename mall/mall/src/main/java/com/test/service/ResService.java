package com.test.service;

import com.test.dao.ResDao;
import com.test.entity.Res;
import com.test.entity.Res2;
import com.test.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ResService {

    @Resource
    private ResDao resDao;

    public List<Res> findAllRes(User user){

        return resDao.findAllRes(user);
    }

    public List<Res> findAllResForRole() {
        return resDao.findAllResForRole();
    };

    public List<Object> findRes() {

        List<Res> list = resDao.findRes();
        List<Object> list2 = new ArrayList<>();


        for (Res r : list) {
            Res2 res2 = new Res2();

            if (r.getParentId().equals("0") || r.getParentId().equals("") || r.getParentId() == null) {
                res2.set_parentId(null);

            } else {

                res2.set_parentId(Integer.parseInt(r.getParentId()));

            }
            res2.setId(r.getId());
            res2.setText(r.getText());
            res2.setChecked(r.getChecked());
            res2.setUrl(r.getUrl());
            list2.add(res2);
        }

        return list2;
    }



    public void saveRess(Res res) {

        Integer id = res.getId();
        if (id == -1) {
            res.setParentId("0");
        } else {
            res.setParentId(id + "");
        }

         resDao.saveRess(res);
    }

    public void updateRess(Res res) {

        String pid = res.getParentId();
        if (pid == null || pid.equals("") || pid.isEmpty()) {
            res.setParentId("0");
        }

        resDao.updateRess(res);
    }

    @Transactional
    public void deleteRess(ArrayList<Integer> data) {

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer rid : data) {

            Res res = resDao.findResByPId(rid);

            if (res == null || res.equals("")) {
                list.add(rid);
            }

        }




       resDao.deleteRess(list);

    }

    @Transactional
    public List<Res> findRoleResByRoleId(int rid) {

        List<Res> list = resDao.findAllResForRole();
        List<Integer> list2 = resDao.findRoleResByRoleId(rid);
       // Set<Integer> set2 = new HashSet<>();
        for (Res res : list) {
            for (Integer rid2 : list2) {
                if (rid2 == res.getId()) {
                    res.setChecked(true);
                }
                Set<Res> children = res.getChildren();
                for (Res res3 : children) {
                    if (rid2 == res3.getId()) {
                        res3.setChecked(true);
                    }

                }


            }

        }



        return list;
    }

}


