package org.maker.pojo;

import java.util.Date;

public class Solicitarticless {
    private Integer solicitarticlesid;

    private String solicitarticlestitle;

    private Integer userqid;

    private Date solicitarticlestime;

    private Integer gambitid;

    private String solicitarticlescover;

    private int greatnumber;

    private int spreadstatus;

    //文章内容
    private String contentStr;
    //上传时间Str
    private String solicitarticlestimeStr;
    //删除id集合
    private String idStr;
    //提交人
    private String solicusername;
    //征文话题Str
    private String gambitnameStr;

    public String getGambitnameStr() {
        return gambitnameStr;
    }

    public void setGambitnameStr(String gambitnameStr) {
        this.gambitnameStr = gambitnameStr;
    }

    public String getSolicusername() {
        return solicusername;
    }

    public void setSolicusername(String solicusername) {
        this.solicusername = solicusername;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getSolicitarticlestimeStr() {
        return solicitarticlestimeStr;
    }

    public void setSolicitarticlestimeStr(String solicitarticlestimeStr) {
        this.solicitarticlestimeStr = solicitarticlestimeStr;
    }

    public String getContentStr() {
        return contentStr;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
    }

    public int getSpreadstatus() {
        return spreadstatus;
    }

    public void setSpreadstatus(int spreadstatus) {
        this.spreadstatus = spreadstatus;
    }

    //提交人姓名
    private String soliusername;
    //微话题
    private String soligambitname;

    public String getSoliusername() {
        return soliusername;
    }

    public void setSoliusername(String soliusername) {
        this.soliusername = soliusername;
    }

    public String getSoligambitname() {
        return soligambitname;
    }

    public void setSoligambitname(String soligambitname) {
        this.soligambitname = soligambitname;
    }

    public int getGreatnumber() {
        return greatnumber;
    }

    public void setGreatnumber(int greatnumber) {
        this.greatnumber = greatnumber;
    }

    public Integer getSolicitarticlesid() {
        return solicitarticlesid;
    }

    public void setSolicitarticlesid(Integer solicitarticlesid) {
        this.solicitarticlesid = solicitarticlesid;
    }

    public String getSolicitarticlestitle() {
        return solicitarticlestitle;
    }

    public void setSolicitarticlestitle(String solicitarticlestitle) {
        this.solicitarticlestitle = solicitarticlestitle == null ? null : solicitarticlestitle.trim();
    }

    public Integer getUserqid() {
        return userqid;
    }

    public void setUserqid(Integer userqid) {
        this.userqid = userqid;
    }

    public Date getSolicitarticlestime() {
        return solicitarticlestime;
    }

    public void setSolicitarticlestime(Date solicitarticlestime) {
        this.solicitarticlestime = solicitarticlestime;
    }

    public Integer getGambitid() {
        return gambitid;
    }

    public void setGambitid(Integer gambitid) {
        this.gambitid = gambitid;
    }

    public String getSolicitarticlescover() {
        return solicitarticlescover;
    }

    public void setSolicitarticlescover(String solicitarticlescover) {
        this.solicitarticlescover = solicitarticlescover == null ? null : solicitarticlescover.trim();
    }
}