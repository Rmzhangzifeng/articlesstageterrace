package org.maker.pojo;

import java.util.Date;

public class Complaints {
    private Integer complaintid;

    private Integer usermid;

    private String complaintcontent;

    private Date complainttime;

    public Integer getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(Integer complaintid) {
        this.complaintid = complaintid;
    }

    public Integer getUsermid() {
        return usermid;
    }

    public void setUsermid(Integer usermid) {
        this.usermid = usermid;
    }

    public String getComplaintcontent() {
        return complaintcontent;
    }

    public void setComplaintcontent(String complaintcontent) {
        this.complaintcontent = complaintcontent == null ? null : complaintcontent.trim();
    }

    public Date getComplainttime() {
        return complainttime;
    }

    public void setComplainttime(Date complainttime) {
        this.complainttime = complainttime;
    }
}