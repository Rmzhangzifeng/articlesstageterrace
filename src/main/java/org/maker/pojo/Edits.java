package org.maker.pojo;

public class Edits {
    private Integer editid;

    private Integer editpid;

    private String edittext;

    private String editurl;

    private String editstatus;

    public Integer getEditid() {
        return editid;
    }

    public void setEditid(Integer editid) {
        this.editid = editid;
    }

    public Integer getEditpid() {
        return editpid;
    }

    public void setEditpid(Integer editpid) {
        this.editpid = editpid;
    }

    public String getEdittext() {
        return edittext;
    }

    public void setEdittext(String edittext) {
        this.edittext = edittext == null ? null : edittext.trim();
    }

    public String getEditurl() {
        return editurl;
    }

    public void setEditurl(String editurl) {
        this.editurl = editurl == null ? null : editurl.trim();
    }

    public String getEditstatus() {
        return editstatus;
    }

    public void setEditstatus(String editstatus) {
        this.editstatus = editstatus == null ? null : editstatus.trim();
    }
}