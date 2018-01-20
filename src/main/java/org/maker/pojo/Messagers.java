package org.maker.pojo;

import java.util.Date;

public class Messagers {
    private Integer contactinformationid;

    private Integer messageexpediterid;

    private Integer messagerecipientid;

    private String messagecontent;

    private Date messagertime;

    private Integer messagetype;

    public Integer getContactinformationid() {
        return contactinformationid;
    }

    public void setContactinformationid(Integer contactinformationid) {
        this.contactinformationid = contactinformationid;
    }

    public Integer getMessageexpediterid() {
        return messageexpediterid;
    }

    public void setMessageexpediterid(Integer messageexpediterid) {
        this.messageexpediterid = messageexpediterid;
    }

    public Integer getMessagerecipientid() {
        return messagerecipientid;
    }

    public void setMessagerecipientid(Integer messagerecipientid) {
        this.messagerecipientid = messagerecipientid;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent == null ? null : messagecontent.trim();
    }

    public Date getMessagertime() {
        return messagertime;
    }

    public void setMessagertime(Date messagertime) {
        this.messagertime = messagertime;
    }

    public Integer getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }
}