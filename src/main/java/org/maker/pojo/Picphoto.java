package org.maker.pojo;

import java.io.Serializable;
import java.util.Date;

public class Picphoto implements Serializable {
    private Integer picphotoid;

    private String picphotourl;

    private Date picuplodtime;

    private String picuplodperson;

    private String piccontent;



    public void setPicphotoid(Integer picphotoid) {
        this.picphotoid = picphotoid;
    }

    public Integer getPicphotoid() {
        return picphotoid;
    }

    public String getPicphotourl() {
        return picphotourl;
    }

    public void setPicphotourl(String picphotourl) {
        this.picphotourl = picphotourl;
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
        this.picuplodperson = picuplodperson;
    }


    public String getPiccontent() {
        return piccontent;
    }

    public void setPiccontent(String piccontent) {
        this.piccontent = piccontent;
    }
}