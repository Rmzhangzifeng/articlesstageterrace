package org.maker.pojo;

import java.util.Date;

public class Discusss {
    private Integer discussid;

    private Integer userwid;

    private String discusscontent;

    private Date discusstime;

    private Integer essaygid;

    //用户名
    private String disusername;
    //评论征文名
    private String disEssayname;
    //批量删除id集合
    private String idStr;

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getDisEssayname() {
        return disEssayname;
    }

    public void setDisEssayname(String disEssayname) {
        this.disEssayname = disEssayname;
    }

    public String getDisusername() {
        return disusername;
    }

    public void setDisusername(String disusername) {
        this.disusername = disusername;
    }

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