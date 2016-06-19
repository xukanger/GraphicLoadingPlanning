package com.just.yt.project.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "t_usergroup")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToMany(cascade= CascadeType.REMOVE ,fetch = FetchType.LAZY, mappedBy = "userGroup")
    Set<User> userSet;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
