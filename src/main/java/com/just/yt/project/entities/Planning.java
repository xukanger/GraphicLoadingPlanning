package com.just.yt.project.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "t_plan")
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String title;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Temporal(TemporalType.DATE)
    private
    Date start_time;

    @Temporal(TemporalType.DATE)
    private
    Date end_time;

    @ManyToOne(cascade= CascadeType.REMOVE)
    User user;

    public Long getLoadnum() {
        return loadnum;
    }

    public void setLoadnum(Long loadnum) {
        this.loadnum = loadnum;
    }

    private Long loadnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
