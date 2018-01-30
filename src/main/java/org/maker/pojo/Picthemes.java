package org.maker.pojo;

import java.io.Serializable;

public class Picthemes implements Serializable {
    private Integer picthemeid;

    private Integer picgroupid;

    private Integer pictypeid;

    private Integer picgroupreview;

    private String picgrouptitle;

    private String picthemeids;

    private  Integer picroles;

    public String getPicthemeids() {
        return picthemeids;
    }

    public void setPicthemeids(String picthemeids) {
        this.picthemeids = picthemeids;
    }

    public Integer getPicroles() {
        return picroles;
    }

    public void setPicroles(Integer picroles) {
        this.picroles = picroles;
    }

    public Integer getPicthemeid() {
        return picthemeid;
    }

    public void setPicthemeid(Integer picthemeid) {
        this.picthemeid = picthemeid;
    }

    public Integer getPicgroupid() {
        return picgroupid;
    }

    public void setPicgroupid(Integer picgroupid) {
        this.picgroupid = picgroupid;
    }

    public Integer getPictypeid() {
        return pictypeid;
    }

    public void setPictypeid(Integer pictypeid) {
        this.pictypeid = pictypeid;
    }

    public Integer getPicgroupreview() {
        return picgroupreview;
    }

    public void setPicgroupreview(Integer picgroupreview) {
        this.picgroupreview = picgroupreview;
    }

    public String getPicgrouptitle() {
        return picgrouptitle;
    }

    public void setPicgrouptitle(String picgrouptitle) {
        this.picgrouptitle = picgrouptitle;
    }
}