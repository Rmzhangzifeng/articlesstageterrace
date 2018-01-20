package org.maker.pojo;

public class Checks {
    private Integer checkid;

    private Integer listid;

    private Integer listtypeid;

    private String checkexcuse;

    private Integer checkman;

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public Integer getListid() {
        return listid;
    }

    public void setListid(Integer listid) {
        this.listid = listid;
    }

    public Integer getListtypeid() {
        return listtypeid;
    }

    public void setListtypeid(Integer listtypeid) {
        this.listtypeid = listtypeid;
    }

    public String getCheckexcuse() {
        return checkexcuse;
    }

    public void setCheckexcuse(String checkexcuse) {
        this.checkexcuse = checkexcuse == null ? null : checkexcuse.trim();
    }

    public Integer getCheckman() {
        return checkman;
    }

    public void setCheckman(Integer checkman) {
        this.checkman = checkman;
    }
}