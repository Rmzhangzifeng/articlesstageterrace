package org.maker.pojo;

import java.io.Serializable;

public class Picgroup implements Serializable {
    private Integer picorganizeid;

    private String picid;

    private String picname;

    private Integer piccover;

    private Integer piclike;


    private String picphotourl;

    private String piccontent;

    private Integer typeid;

    private String picgrouptitle;

    private Integer picgroupreview;



    public Integer getPicorganizeid() {
        return picorganizeid;
    }

    public void setPicorganizeid(Integer picorganizeid) {
        this.picorganizeid = picorganizeid;
    }

    public String getPicid() {
        return picid;
    }

    public void setPicid(String picid) {
        this.picid = picid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPiccontent() {
        return piccontent;
    }

    public void setPiccontent(String piccontent) {
        this.piccontent = piccontent;
    }

    public Integer getPiccover() {
        return piccover;
    }

    public void setPiccover(Integer piccover) {
        this.piccover = piccover;
    }

    public Integer getPiclike() {
        return piclike;
    }

    public void setPiclike(Integer piclike) {
        this.piclike = piclike;
    }

    public String getPicphotourl() {
        return picphotourl;
    }

    public void setPicphotourl(String picphotourl) {
        this.picphotourl = picphotourl;
    }


    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getPicgrouptitle() {
        return picgrouptitle;
    }

    public void setPicgrouptitle(String picgrouptitle) {
        this.picgrouptitle = picgrouptitle;
    }

    public Integer getPicgroupreview() {
        return picgroupreview;
    }

    public void setPicgroupreview(Integer picgroupreview) {
        this.picgroupreview = picgroupreview;
    }
}