package com.test.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class Role implements Serializable{

    private Integer rid;
    private String rname;
    private Set<UserRole> userRole;

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }



}
