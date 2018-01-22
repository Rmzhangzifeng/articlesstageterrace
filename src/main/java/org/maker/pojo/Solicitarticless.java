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