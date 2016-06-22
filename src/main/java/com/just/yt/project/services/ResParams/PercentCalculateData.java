package com.just.yt.project.services.ResParams;

/**
 * Created by yt on 2016/6/20.
 */

public class PercentCalculateData {
    public long count;
    public long sum;
    public double percent;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PercentCalculateData(long count, long sum) {
        this.count = count;
        this.sum = sum;
        this.percent=(double) count/(double)sum;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
