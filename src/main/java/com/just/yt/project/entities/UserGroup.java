package com.just.yt.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "usergroup")
public class UserGroup {
    @Id
    Integer id;


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
}
