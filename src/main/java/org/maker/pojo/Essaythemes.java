package org.maker.pojo;

import java.util.Date;

public class Essaythemes {
    private Integer articletopicid;

    private String title;

    private String themecontent;

    private Date themestarttime;

    private Date themeendtime;

    public Integer getArticletopicid() {
        return articletopicid;
    }

    public void setArticletopicid(Integer articletopicid) {
        this.articletopicid = articletopicid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getThemecontent() {
        return themecontent;
    }

    public void setThemecontent(String themecontent) {
        this.themecontent = themecontent == null ? null : themecontent.trim();
    }

    public Date getThemestarttime() {
        return themestarttime;
    }

    public void setThemestarttime(Date themestarttime) {
        this.themestarttime = themestarttime;
    }

    public Date getThemeendtime() {
        return themeendtime;
    }

    public void setThemeendtime(Date themeendtime) {
        this.themeendtime = themeendtime;
    }
}