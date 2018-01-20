package org.maker.pojo;

import java.util.Date;

public class Awardss {
    private Integer awardsid;

    private Date awardstime;

    private Integer awardsmoney;

    private String awardsexcuse;

    private Integer articlevid;

    public Integer getAwardsid() {
        return awardsid;
    }

    public void setAwardsid(Integer awardsid) {
        this.awardsid = awardsid;
    }

    public Date getAwardstime() {
        return awardstime;
    }

    public void setAwardstime(Date awardstime) {
        this.awardstime = awardstime;
    }

    public Integer getAwardsmoney() {
        return awardsmoney;
    }

    public void setAwardsmoney(Integer awardsmoney) {
        this.awardsmoney = awardsmoney;
    }

    public String getAwardsexcuse() {
        return awardsexcuse;
    }

    public void setAwardsexcuse(String awardsexcuse) {
        this.awardsexcuse = awardsexcuse == null ? null : awardsexcuse.trim();
    }

    public Integer getArticlevid() {
        return articlevid;
    }

    public void setArticlevid(Integer articlevid) {
        this.articlevid = articlevid;
    }
}