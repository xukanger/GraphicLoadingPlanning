package com.just.yt.project.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "user")
public class User {
    @Id
    private Integer id;

    private String account_name;

    private String password;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    private UserGroup userGroup;

    @OneToMany(cascade= CascadeType.REMOVE ,fetch = FetchType.EAGER, mappedBy = "user")
    private
    Set<Planning> planningArrayList;


    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Set<Planning> getPlanningArrayList() {
        return planningArrayList;
    }

    public void setPlanningArrayList(Set<Planning> planningArrayList) {
        this.planningArrayList = planningArrayList;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
