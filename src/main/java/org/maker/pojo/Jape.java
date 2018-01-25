package org.maker.pojo;

import java.io.Serializable;
import java.util.Date;

public class Jape implements Serializable {
    private Integer wybid;

    private String wybjapename;

    private Date wybjapetime;

    private String wybcontent;

    private Integer wybtypeid;

    private Integer wybjapeid;

    private String username;

    private Integer wybgood;

    private Integer wybfist;

    private String wybdate;
    private Integer wyblike;
    private Integer wyblikes;

    public Integer getWybid() {
        return wybid;
    }

    public void setWybid(Integer wybid) {
        this.wybid = wybid;
    }

    public String getWybjapename() {
        return wybjapename;
    }

    public void setWybjapename(String wybjapename) {
        this.wybjapename = wybjapename == null ? null : wybjapename.trim();
    }

    public Date getWybjapetime() {
        return wybjapetime;
    }

    public void setWybjapetime(Date wybjapetime) {
        this.wybjapetime = wybjapetime;
    }

    public String getWybcontent() {
        return wybcontent;
    }

    public void setWybcontent(String wybcontent) {
        this.wybcontent = wybcontent == null ? null : wybcontent.trim();
    }

    public Integer getWybtypeid() {
        return wybtypeid;
    }

    public void setWybtypeid(Integer wybtypeid) {
        this.wybtypeid = wybtypeid;
    }

    public Integer getWybjapeid() {
        return wybjapeid;
    }

    public void setWybjapeid(Integer wybjapeid) {
        this.wybjapeid = wybjapeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWybgood() {
        return wybgood;
    }

    public void setWybgood(Integer wybgood) {
        this.wybgood = wybgood;
    }

    public Integer getWybfist() {
        return wybfist;
    }

    public void setWybfist(Integer wybfist) {
        this.wybfist = wybfist;
    }

    public String getWybdate() {
        return wybdate;
    }

    public void setWybdate(String wybdate) {
        this.wybdate = wybdate;
    }

    public Integer getWyblike() {
        return wyblike;
    }

    public void setWyblike(Integer wyblike) {
        this.wyblike = wyblike;
    }

    public Integer getWyblikes() {
        return wyblikes;
    }

    public void setWyblikes(Integer wyblikes) {
        this.wyblikes = wyblikes;
    }
}