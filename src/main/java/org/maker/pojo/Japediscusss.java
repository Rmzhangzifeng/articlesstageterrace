package org.maker.pojo;

import java.util.Date;

public class Japediscusss {
    private Integer japediscussid;

    private Integer usergid;

    private String japediscusscontent;

    private Date japediscusstime;

    private Integer japediscussstatus;

    private Integer japecid;

    public Integer getJapediscussid() {
        return japediscussid;
    }

    public void setJapediscussid(Integer japediscussid) {
        this.japediscussid = japediscussid;
    }

    public Integer getUsergid() {
        return usergid;
    }

    public void setUsergid(Integer usergid) {
        this.usergid = usergid;
    }

    public String getJapediscusscontent() {
        return japediscusscontent;
    }

    public void setJapediscusscontent(String japediscusscontent) {
        this.japediscusscontent = japediscusscontent == null ? null : japediscusscontent.trim();
    }

    public Date getJapediscusstime() {
        return japediscusstime;
    }

    public void setJapediscusstime(Date japediscusstime) {
        this.japediscusstime = japediscusstime;
    }

    public Integer getJapediscussstatus() {
        return japediscussstatus;
    }

    public void setJapediscussstatus(Integer japediscussstatus) {
        this.japediscussstatus = japediscussstatus;
    }

    public Integer getJapecid() {
        return japecid;
    }

    public void setJapecid(Integer japecid) {
        this.japecid = japecid;
    }
}