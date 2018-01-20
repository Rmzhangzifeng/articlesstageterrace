package org.maker.pojo;

public class Anchorwomans {
    private Integer anchorwomanid;

    private String anchorwomanname;

    private String anchorwomanidentity;

    private String anchorwomanaccount;

    private String anchorwomanpass;

    public Integer getAnchorwomanid() {
        return anchorwomanid;
    }

    public void setAnchorwomanid(Integer anchorwomanid) {
        this.anchorwomanid = anchorwomanid;
    }

    public String getAnchorwomanname() {
        return anchorwomanname;
    }

    public void setAnchorwomanname(String anchorwomanname) {
        this.anchorwomanname = anchorwomanname == null ? null : anchorwomanname.trim();
    }

    public String getAnchorwomanidentity() {
        return anchorwomanidentity;
    }

    public void setAnchorwomanidentity(String anchorwomanidentity) {
        this.anchorwomanidentity = anchorwomanidentity == null ? null : anchorwomanidentity.trim();
    }

    public String getAnchorwomanaccount() {
        return anchorwomanaccount;
    }

    public void setAnchorwomanaccount(String anchorwomanaccount) {
        this.anchorwomanaccount = anchorwomanaccount == null ? null : anchorwomanaccount.trim();
    }

    public String getAnchorwomanpass() {
        return anchorwomanpass;
    }

    public void setAnchorwomanpass(String anchorwomanpass) {
        this.anchorwomanpass = anchorwomanpass == null ? null : anchorwomanpass.trim();
    }
}