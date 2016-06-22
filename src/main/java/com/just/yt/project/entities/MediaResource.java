package com.just.yt.project.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

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


    public Set<Planning> getPlanningSet() {
        return planningSet;
    }

    public void setPlanningSet(Set<Planning> planningSet) {
        this.planningSet = planningSet;
    }

    @OneToMany(cascade= CascadeType.REMOVE ,fetch = FetchType.LAZY, mappedBy = "mediaResource")
    private Set<Planning> planningSet;

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
