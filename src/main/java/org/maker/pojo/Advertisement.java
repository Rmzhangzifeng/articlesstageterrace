package org.maker.pojo;

import java.util.Date;

public class Advertisement {
    private Integer adid;

    private String adname;

    private String adimg;

    private Date adshowdate;

    private String addate;

    private Integer adstataus;

    private String adhttp;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }

    public String getAdimg() {
        return adimg;
    }

    public void setAdimg(String adimg) {
        this.adimg = adimg == null ? null : adimg.trim();
    }

    public Date getAdshowdate() {
        return adshowdate;
    }

    public void setAdshowdate(Date adshowdate) {
        this.adshowdate = adshowdate;
    }

    public Integer getAdstataus() {
        return adstataus;
    }

    public void setAdstataus(Integer adstataus) {
        this.adstataus = adstataus;
    }

    public String getAddate() {
        return addate;
    }

    public void setAddate(String addate) {
        this.addate = addate;
    }

    public String getAdhttp() {
        return adhttp;
    }

    public void setAdhttp(String adhttp) {
        this.adhttp = adhttp;
    }
}