package org.maker.pojo;

import java.util.Date;

public class Frequencys {
    private Integer frequencyid;

    private String frequencytitle;

    private Integer anchorid;

    private String frequencysource;

    private Date releasetime;

    private String frequencyconver;

    private Integer frequencyreview;

    private String frequencyids;

    public String getFrequencyids() {
        return frequencyids;
    }

    public void setFrequencyids(String frequencyids) {
        this.frequencyids = frequencyids;
    }

    public Integer getFrequencyreview() {
        return frequencyreview;
    }

    public void setFrequencyreview(Integer frequencyreview) {
        this.frequencyreview = frequencyreview;
    }

    public Integer getFrequencyid() {
        return frequencyid;
    }

    public void setFrequencyid(Integer frequencyid) {
        this.frequencyid = frequencyid;
    }

    public String getFrequencytitle() {
        return frequencytitle;
    }

    public void setFrequencytitle(String frequencytitle) {
        this.frequencytitle = frequencytitle == null ? null : frequencytitle.trim();
    }

    public Integer getAnchorid() {
        return anchorid;
    }

    public void setAnchorid(Integer anchorid) {
        this.anchorid = anchorid;
    }

    public String getFrequencysource() {
        return frequencysource;
    }

    public void setFrequencysource(String frequencysource) {
        this.frequencysource = frequencysource == null ? null : frequencysource.trim();
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getFrequencyconver() {
        return frequencyconver;
    }

    public void setFrequencyconver(String frequencyconver) {
        this.frequencyconver = frequencyconver == null ? null : frequencyconver.trim();
    }
}