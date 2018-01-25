package org.maker.pojo;

public class DemoPojo {
    private Integer demoid;

    private String demoname;

    public Integer getDemoid() {
        return demoid;
    }

    public void setDemoid(Integer demoid) {
        this.demoid = demoid;
    }

    public String getDemoname() {
        return demoname;
    }

    public void setDemoname(String demoname) {
        this.demoname = demoname == null ? null : demoname.trim();
    }
}