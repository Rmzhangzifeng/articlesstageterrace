package org.maker.pojo;

import java.util.Date;

public class Messagers {
    private Integer contactinformationid;

    private String messageexpeditername;

    private String messagerecipientuser;

    private String messagecontent;

    private Date messagertime;

    private Integer messagetype;

    private String messagerdate;

    private String messagertitle;


    public Integer getContactinformationid() {
        return contactinformationid;
    }

    public void setContactinformationid(Integer contactinformationid) {
        this.contactinformationid = contactinformationid;
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


    public String getMessageexpeditername() {
        return messageexpeditername;
    }

    public void setMessageexpeditername(String messageexpeditername) {
        this.messageexpeditername = messageexpeditername;
    }



    public String getMessagecontent() {
        return messagecontent;
    }

    public String getMessagerdate() {
        return messagerdate;
    }

    public void setMessagerdate(String messagerdate) {
        this.messagerdate = messagerdate;
    }



    public String getMessagertitle() {
        return messagertitle;
    }

    public void setMessagertitle(String messagertitle) {
        this.messagertitle = messagertitle;
    }

    public String getMessagerecipientuser() {
        return messagerecipientuser;
    }

    public void setMessagerecipientuser(String messagerecipientuser) {
        this.messagerecipientuser = messagerecipientuser;
    }
}