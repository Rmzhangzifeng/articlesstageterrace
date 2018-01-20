package org.maker.pojo;

import java.util.Date;

public class Picphotos {
    private Integer picphotoid;

    private String picphotourl;

    private Date picuplodtime;

    private String picuplodperson;

    private String piccontent;

    public Integer getPicphotoid() {
        return picphotoid;
    }

    public void setPicphotoid(Integer picphotoid) {
        this.picphotoid = picphotoid;
    }

    public String getPicphotourl() {
        return picphotourl;
    }

    public void setPicphotourl(String picphotourl) {
        this.picphotourl = picphotourl == null ? null : picphotourl.trim();
    }

    public Date getPicuplodtime() {
        return picuplodtime;
    }

    public void setPicuplodtime(Date picuplodtime) {
        this.picuplodtime = picuplodtime;
    }

    public String getPicuplodperson() {
        return picuplodperson;
    }

    public void setPicuplodperson(String picuplodperson) {
        this.picuplodperson = picuplodperson == null ? null : picuplodperson.trim();
    }

    public String getPiccontent() {
        return piccontent;
    }

    public void setPiccontent(String piccontent) {
        this.piccontent = piccontent == null ? null : piccontent.trim();
    }
}