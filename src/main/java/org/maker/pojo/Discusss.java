package org.maker.pojo;

import java.util.Date;

public class Discusss {
    private Integer discussid;

    private Integer userwid;

    private String discusscontent;

    private Date discusstime;

    private Integer essaygid;

    public Integer getDiscussid() {
        return discussid;
    }

    public void setDiscussid(Integer discussid) {
        this.discussid = discussid;
    }

    public Integer getUserwid() {
        return userwid;
    }

    public void setUserwid(Integer userwid) {
        this.userwid = userwid;
    }

    public String getDiscusscontent() {
        return discusscontent;
    }

    public void setDiscusscontent(String discusscontent) {
        this.discusscontent = discusscontent == null ? null : discusscontent.trim();
    }

    public Date getDiscusstime() {
        return discusstime;
    }

    public void setDiscusstime(Date discusstime) {
        this.discusstime = discusstime;
    }

    public Integer getEssaygid() {
        return essaygid;
    }

    public void setEssaygid(Integer essaygid) {
        this.essaygid = essaygid;
    }
}