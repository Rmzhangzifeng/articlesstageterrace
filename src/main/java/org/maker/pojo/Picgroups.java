package org.maker.pojo;

public class Picgroups {
    private Integer picorganizeid;

    private String picid;

    private String picname;

    private Integer piccover;

    private Integer piclike;

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
        this.picid = picid == null ? null : picid.trim();
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
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
}