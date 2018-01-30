package org.maker.pojo;

import java.util.List;

public class Edits {
    private Integer editid;

    private Integer editpid;

    private String edittext;

    private String editurl;

    private String editstatus;

    private Integer id;

    private Integer pid;

    private String text;

    private  String href;
    private List<Edits> nodes;
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

    public List<Edits> getNodes() {
        return nodes;
    }

    public void setNodes(List<Edits> nodes) {
        this.nodes = nodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() { return pid; }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}