package org.maker.pojo;

import java.util.List;

public class Trees {



    private String id;
    private String text;
    private String pid;
    private String href;
    private List<Trees> nodes;//子节点列表


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Trees> getNodes() {
        return nodes;
    }

    public void setNodes(List<Trees> nodes) {
        this.nodes = nodes;
    }
}