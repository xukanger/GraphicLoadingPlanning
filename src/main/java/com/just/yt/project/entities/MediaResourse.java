package com.just.yt.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by yt on 2016/6/5.
 */
@Entity(name = "media_resourse")
public class MediaResourse {
    @Id
    Integer id;

    Long remain;

    Long sum;

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
}
