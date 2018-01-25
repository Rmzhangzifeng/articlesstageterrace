package org.maker.pojo;

import java.util.Date;

public class Picreview {
    private Integer picreviewid;

    private String picreviewcontent;

    private Integer usernid;

    private Integer picphotosid;

    private Integer pictopicszid;

    private Integer picstatus;

    private Date picwybdate;

    private String pictime;


    private String username;


    public Integer getPicreviewid() {
        return picreviewid;
    }

    public void setPicreviewid(Integer picreviewid) {
        this.picreviewid = picreviewid;
    }

    public String getPicreviewcontent() {
        return picreviewcontent;
    }

    public void setPicreviewcontent(String picreviewcontent) {
        this.picreviewcontent = picreviewcontent == null ? null : picreviewcontent.trim();
    }

    public Integer getUsernid() {
        return usernid;
    }

    public void setUsernid(Integer usernid) {
        this.usernid = usernid;
    }

    public Integer getPicphotosid() {
        return picphotosid;
    }

    public void setPicphotosid(Integer picphotosid) {
        this.picphotosid = picphotosid;
    }

    public Integer getPictopicszid() {
        return pictopicszid;
    }

    public void setPictopicszid(Integer pictopicszid) {
        this.pictopicszid = pictopicszid;
    }


    public Integer getPicstatus() {
        return picstatus;
    }

    public void setPicstatus(Integer picstatus) {
        this.picstatus = picstatus;
    }


    public String getPictime() {
        return pictime;
    }

    public void setPictime(String pictime) {
        this.pictime = pictime;
    }

    public Date getPicwybdate() {
        return picwybdate;
    }

    public void setPicwybdate(Date picwybdate) {
        this.picwybdate = picwybdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}