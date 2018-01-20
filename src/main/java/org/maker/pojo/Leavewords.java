package org.maker.pojo;

public class Leavewords {
    private Integer leavewordid;

    private Integer adminid;

    private String leavewordcontent;

    private Integer byadminid;

    private Integer leavewordtype;

    public Integer getLeavewordid() {
        return leavewordid;
    }

    public void setLeavewordid(Integer leavewordid) {
        this.leavewordid = leavewordid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getLeavewordcontent() {
        return leavewordcontent;
    }

    public void setLeavewordcontent(String leavewordcontent) {
        this.leavewordcontent = leavewordcontent == null ? null : leavewordcontent.trim();
    }

    public Integer getByadminid() {
        return byadminid;
    }

    public void setByadminid(Integer byadminid) {
        this.byadminid = byadminid;
    }

    public Integer getLeavewordtype() {
        return leavewordtype;
    }

    public void setLeavewordtype(Integer leavewordtype) {
        this.leavewordtype = leavewordtype;
    }
}