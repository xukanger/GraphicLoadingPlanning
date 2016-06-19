package com.just.yt.project.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "t_media_resource")
public class MediaResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long remain;

    private Long sum;

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    String resource_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRemain() {
        return remain;
    }

    public void setRemain(Long remain) {
        this.remain = remain;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
